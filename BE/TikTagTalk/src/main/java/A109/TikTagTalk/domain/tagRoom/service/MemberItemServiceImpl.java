package A109.TikTagTalk.domain.tagRoom.service;

import A109.TikTagTalk.domain.account.dto.response.ResponseDto;
import A109.TikTagTalk.domain.account.dto.response.ResponseUtil;
import A109.TikTagTalk.domain.account.entity.Account;
import A109.TikTagTalk.domain.account.repository.AccountRepository;
import A109.TikTagTalk.domain.tag.entity.Tag;
import A109.TikTagTalk.domain.tag.repository.TagRepository;
import A109.TikTagTalk.domain.tagRoom.dto.request.InitMemberItemRequestDto;
import A109.TikTagTalk.domain.tagRoom.dto.request.UpdateMemberItemRequestDto;
import A109.TikTagTalk.domain.tagRoom.dto.response.InitMemberItemResponseDto;
import A109.TikTagTalk.domain.tagRoom.entity.Item;
import A109.TikTagTalk.domain.tagRoom.entity.MemberItem;
import A109.TikTagTalk.domain.tagRoom.repository.MemberItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberItemServiceImpl implements MemberItemService{
    private final MemberItemRepository memberItemRepository;
    private final TagRepository tagRepository;
    private final AccountRepository accountRepository;
    @Override
    @Transactional
    public void memberItemInit(InitMemberItemRequestDto requestDto) {
        Account account=accountRepository.findById(requestDto.getAccountId()).get();
        Tag tag = tagRepository.findById(requestDto.getTag().getId()).get();
        List<Item> itemList=tag.getItemList();
        for(Item i:itemList){
            Long positionY=0L;
            Long positionX=0L;
            Long positionZ=0L;
            Long sizeX=0L;
            Long sizeY=0L;
            Boolean room=false;
            Boolean wall=false;
            if(i.getName().equals("room")){
                positionX=0L;
                positionY=0L;
                positionZ=0L;
                sizeX=14L;
                sizeY=14L;
                room=true;
            }
            else if(i.getName().equals("bed")){
                positionX=0L;
                positionY=7L;
                positionZ=1L;
                sizeX=9L;
                sizeY=7L;
            }
            else if(i.getName().equals("chair")){
                positionX=9L;
                positionY=4L;
                positionZ=1L;
                sizeX=3L;
                sizeY=4L;
            }
            else if(i.getName().equals("closet")){
                positionX=2L;
                positionY=1L;
                positionZ=1L;
                sizeX=4L;
                sizeY=3L;
            }else if(i.getName().equals("shelf")){
                positionX=5L;
                positionY=0L;
                positionZ=1L;
                sizeX=5L;
                sizeY=3L;
                wall=true;
            }else{
                positionX=8L;
                positionY=1L;
                positionZ=1L;
                sizeX=5L;
                sizeY=3L;
            }
            MemberItem memberItem=MemberItem.builder()
                    .account(account)
                    .item(i)
                    .wall(wall)
                    .room(room)
                    .positionX(positionX)
                    .positionY(positionY)
                    .positoinZ(positionZ)
                    .sizeX(sizeX)
                    .sizeY(sizeY)
                    .build();
            memberItemRepository.save(memberItem);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<InitMemberItemResponseDto> findMemberItems(Long accountId) {
        Account account=accountRepository.findById(accountId).get();
        List<MemberItem> memberItemList=memberItemRepository.findMemberItem(account);
        return memberItemList.stream()
                .map(memberItem -> {
                    InitMemberItemResponseDto.ItemDto itemDto=InitMemberItemResponseDto.ItemDto.builder()
                            .name(memberItem.getItem().getName()).build();
                    return InitMemberItemResponseDto.builder()
                            .item(itemDto)
                            .position_x(memberItem.getPositionX())
                            .position_y(memberItem.getPositionY())
                            .grid_z_number(memberItem.getPositoinZ())
                            .size_x(memberItem.getSizeX())
                            .size_y(memberItem.getSizeY())
                            .room(memberItem.isRoom())
                            .wall(memberItem.isWall())
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ResponseDto updateMemberItem(UpdateMemberItemRequestDto requestDto) {
        Account account=accountRepository.findById(requestDto.getAccount().getId()).get();
        MemberItem memberItem=memberItemRepository.findByAccountItemName(account,requestDto.getItem().getName());
        memberItemRepository.updateMemberItem(memberItem,requestDto);
        return ResponseUtil.Success("에셋 위치 수정 성공");
    }
}