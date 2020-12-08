package org.zerock.ex3.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.ex3.dto.SampleDTO;


@Controller
@RequestMapping("/sample")
public class SampleController {

    @GetMapping("/ex1")
    public void ex1(Model model){
        model.addAttribute("msg", "Hello World");
    }


    @GetMapping("/ex2")
    public void ex2(Model model){

        SampleDTO dto = SampleDTO.builder()
                .sno(10L)
                .title("test title")
                .writer("user00")
                .build();

        model.addAttribute("dto", dto);
    }

    @GetMapping("/ex3")
    public void ex3(Model model){

        List<SampleDTO> list = IntStream.rangeClosed(1,100).mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder()
                    .sno((long)i)
                    .title("Title.."+i)
                    .writer("user"+(i%10))
                    .build();
            return dto;
        }).collect(Collectors.toList());
        model.addAttribute("dtoList", list);
    }
}