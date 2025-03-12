package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ParentRequest;
import com.example.entity.Parent;
import com.example.service.ParentService;

@RestController
@RequestMapping("/parent")
@CrossOrigin
public class ParentController {

    @Autowired
    private ParentService parentService;

    @GetMapping
    public List<Parent> getAll() {
        return parentService.getAllParents();
    }

    @GetMapping("/{parentId}")
    public ResponseEntity<Parent> getById(@PathVariable Long parentId) {
        Parent parent = parentService.getParentById(parentId);
        return ResponseEntity.ok(parent);
    }

    @PostMapping
    public ResponseEntity<Parent> save(@RequestBody ParentRequest parentRequest) {
        Parent savedParent = parentService.saveParent(parentRequest);
        return new ResponseEntity<>(savedParent, HttpStatus.CREATED);
    }

    @DeleteMapping("/{parentId}")
    public ResponseEntity<Void> delete(@PathVariable Long parentId) {
        parentService.deleteParent(parentId);
        return ResponseEntity.noContent().build();
    }
}
