package hello.servlet.web.springmvc.v2;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

@Controller
@RequestMapping("/springmvc/v2/members")
public class SpringMemberControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form")
    public ModelAndView newForm() {
        return new ModelAndView("new-form");
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest req) {
        String username = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelAndView model = new ModelAndView("save-result");
        model.addObject("member", member);

        return model;
    }

    @RequestMapping
    public ModelAndView showList(HttpServletRequest req) {

        List<Member> all = memberRepository.findAll();

        ModelAndView model = new ModelAndView("members");
        model.addObject("members", all);

        return model;
    }
}
