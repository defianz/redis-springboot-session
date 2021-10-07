package me.defian.sessionspringboot.controller;

import me.defian.sessionspringboot.dto.MemberRequestDto;
import me.defian.sessionspringboot.dto.MemberResponseDto;
import me.defian.sessionspringboot.entity.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DefianController {


    private static Long idx = 0L;
    List<MemberResponseDto> memberList = new ArrayList<>();

    Logger logger = LoggerFactory.getLogger(getClass());


    @PostMapping("/session/members/login.do")
    public String login(MemberRequestDto memberRequestDto, Model model){

        Member member = new Member(idx++, memberRequestDto.getUsername(), memberRequestDto.getPassword());

        MemberResponseDto memberResponseDto = new MemberResponseDto(member.getId(),member.getUsername());

        memberList.add(memberResponseDto);
        model.addAttribute("memberList",memberList);
//        logger.error(memberList.get(0).toString());
        return "/member";
    }

    @GetMapping("/hi")
    public void hi(){
        logger.error("hi");
    }
}
