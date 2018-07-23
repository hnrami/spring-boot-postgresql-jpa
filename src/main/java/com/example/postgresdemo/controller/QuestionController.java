package com.example.postgresdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postgresdemo.model.Question;
import com.example.postgresdemo.repository.QuestionRepository;

@RestController
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;
    
    

    
    @GetMapping("/questions")
    public Page<Question> getQuestions(Pageable pageable) {
    	//System.out.println(questionRepository.getallDate().size());;
        return questionRepository.findAll(pageable);
    }
    
    @PostMapping("/questionsRead")
    public List<Question> getreadcustomeQuestions(String title,String dec) {
    	System.out.println("title"+title+"dec"+dec);
    	System.out.println(questionRepository.getSecondMehtodofJPA(title, dec));
    	return questionRepository.getfirstMehtodofJPA(title, dec);
    }


//    @PostMapping("/questions")
//    public Question createQuestion(@Valid @RequestBody Question question) {
//        return questionRepository.save(question);
//    }
//
//    @PutMapping("/questions/{questionId}")
//    public Question updateQuestion(@PathVariable Long questionId,
//                                   @Valid @RequestBody Question questionRequest) {
//        return questionRepository.findById(questionId)
//                .map(question -> {
//                    question.setTitle(questionRequest.getTitle());
//                    question.setDescription(questionRequest.getDescription());
//                    return questionRepository.save(question);
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }
//
//
//    @DeleteMapping("/questions/{questionId}")
//    public ResponseEntity<?> deleteQuestion(@PathVariable Long questionId) {
//        return questionRepository.findById(questionId)
//                .map(question -> {
//                    questionRepository.delete(question);
//                    return ResponseEntity.ok().build();
//                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + questionId));
//    }
}
