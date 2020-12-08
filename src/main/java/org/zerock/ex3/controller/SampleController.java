package org.zerock.ex3.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.ex3.dto.SampleDTO;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
    @GetMapping("/ex1")
    public void ex1() {

        log.info("ex1...............");
    }

    @GetMapping({"/ex2"})
    public void exModel(Model model) {

        SampleDTO dto = SampleDTO.builder()
                    .sno(10L)
                    .title("test title")
                    .writer("user00")
                    .build();

        model.addAttribute("dto", dto);
    }

//    @GetMapping({"/exInline"})
//    public String exInline(RedirectAttributes redirectAttributes){
//
//        log.info("exInline...........");
//
//        SampleDTO dto = SampleDTO.builder()
//                .sno(100L)
//                .first("First...100")
//                .last("Last...100")
//                .regTime(LocalDateTime.now())
//                .build();
//        redirectAttributes.addFlashAttribute("result", "success");
//        redirectAttributes.addFlashAttribute("dto", dto);
//
//        return "redirect:/sample/ex3";
//    }

    @GetMapping("/ex3")
    public void ex3(Model model) {

        log.info("ex3");

        List<SampleDTO> list = IntStream.rangeClosed(1,100).mapToObj(i -> {
            SampleDTO dto = SampleDTO.builder()
                    .sno((long)i)
                    .title("Title"+i)
                    .writer("user"+(i%10))
                    .build();
            return dto;
        }).collect(Collectors.toList());
        model.addAttribute("dtoList", list);
    }

}
