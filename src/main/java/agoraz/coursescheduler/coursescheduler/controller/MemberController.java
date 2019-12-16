package agoraz.coursescheduler.coursescheduler.controller;


import agoraz.coursescheduler.coursescheduler.model.Member;
import agoraz.coursescheduler.coursescheduler.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/members"})
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // CRUD methods

    //Retrieve All members (GET /members)
    @GetMapping
    public List findAll() {return memberRepository.findAll();}

    //Retrieve a member by ID (GET /members/{id})
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Member> findById(@PathVariable Long id){
        return memberRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //Create a new member (POST /members)
    @PostMapping//(consumes=MediaType.APPLICATION_JSON_VALUE)
    public Member create(@RequestBody Member member) {

        return memberRepository.save(member);
    }

    //Update a Member (PUT /members)
    @PutMapping(value="/{id}")
    public ResponseEntity<Member> update(@PathVariable("id") long id,
                                         @RequestBody Member member){
        return memberRepository.findById(id)
                .map(record -> {
                    record.setName(member.getName());
                    record.setFirstName(member.getFirstName());
                    Member updated = memberRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    //Remove a Member (DELETE /members/{id})
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return memberRepository.findById(id)
                .map(record -> {
                    memberRepository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
