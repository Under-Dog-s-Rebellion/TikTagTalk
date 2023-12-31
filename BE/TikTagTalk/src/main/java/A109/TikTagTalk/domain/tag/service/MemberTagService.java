package A109.TikTagTalk.domain.tag.service;

import A109.TikTagTalk.domain.tag.dto.request.CheckMemberTagRequestDto;
import A109.TikTagTalk.domain.tag.dto.response.CheckMemberTagResponseDto;
import A109.TikTagTalk.domain.user.entity.Member;

import java.util.List;

public interface MemberTagService {
    List<CheckMemberTagResponseDto> checkMemberTagList(CheckMemberTagRequestDto requestDto, Member member);

}
