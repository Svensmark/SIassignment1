package stu.si.myexams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import stu.si.myexams.exceptions.ExamNotFoundException;
import stu.si.myexams.model.Exam;
import stu.si.myexams.repository.ExamRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exams")
public class ExamController
{
    @Autowired
    ExamRepository repo;
    @GetMapping("/all")
    public List<Exam> retrieveAllExams()
    {
        return repo.findAll();
    }

    // This is the only method, which returns hyperlinks, for now
    // If the resource is found, a link to its 'family' is appended to its native load
    @GetMapping("/{id}")
    public EntityModel<Exam> retrieveExam(@PathVariable long id)
    {
        Optional<Exam> exam = repo.findById(id);
        if (!exam.isPresent())
            throw new ExamNotFoundException("id: " + id);

        EntityModel<Exam> resource = EntityModel.of(exam.get()); 						// get the resource
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllExams()); // get link
        resource.add(linkTo.withRel("all-exam"));										// append the link

        Link selfLink = linkTo(methodOn(this.getClass()).retrieveExam(id)).withSelfRel(); //add also link to self
        resource.add(selfLink);
        return resource;
    }

    @DeleteMapping("/{id}")
    public void deleteExam(@PathVariable long id) {
        repo.deleteById(id);
    }

    // Create a new resource and remember its unique location in the hypermedia
    @PostMapping("/")
    public ResponseEntity<Object> createExam(@RequestBody Exam exam)
    {
        Exam savedExam = repo.save(exam);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedExam.getEid()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExam(@RequestBody Exam exam, @PathVariable long id)
    {
        Optional<Exam> studentOptional = repo.findById(id);
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        exam.setEid(id);
        repo.save(exam);
        return ResponseEntity.noContent().build();
    }
}
