package com.ifortex.bookservice.service.impl;

import com.ifortex.bookservice.model.Member;
import com.ifortex.bookservice.service.MemberService;
import org.springframework.stereotype.Service;
import com.ifortex.bookservice.repository.MemberRepository;

import java.util.List;

// Attention! It is FORBIDDEN to make any changes in this file!
@Service
public class ESMemberServiceImpl implements MemberService {

  @Inject
  private MemberRepository memberRepository;

  @Override
  public Member findMember() {

    return memberRepository.getMember();
  }

  @Override
  public List<Member> findMembers() {

    return memberRepository.findMembers();

  }
}
