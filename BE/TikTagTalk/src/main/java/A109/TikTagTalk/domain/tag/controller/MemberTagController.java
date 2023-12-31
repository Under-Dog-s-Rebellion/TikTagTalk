package A109.TikTagTalk.domain.tag.controller;

import A109.TikTagTalk.domain.tag.dto.request.CheckMemberTagRequestDto;
import A109.TikTagTalk.domain.tag.dto.response.CheckMemberTagResponseDto;
import A109.TikTagTalk.domain.tag.service.MemberTagService;
import A109.TikTagTalk.domain.user.entity.Member;
import A109.TikTagTalk.global.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/membertag")
@Slf4j
public class MemberTagController {
    private final MemberTagService memberTagService;
    @PostMapping("") //획득한 tag 조회
    public List<CheckMemberTagResponseDto> checkMemberTagList(@RequestBody CheckMemberTagRequestDto requestDto){
        Member member= SecurityUtil.getCurrentLoginMember();
        return memberTagService.checkMemberTagList(requestDto,member);
    }

}
