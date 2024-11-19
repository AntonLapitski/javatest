package com.ifortex.bookservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.EntityManager;

public class BookRepository {

    @Autowired
    private EntityManger entityManager;

    public getMember() {
        String sql = "SELECT name
                      FROM members m
                      JOIN member_books mm ON m.id = mm.member_id
                      JOIN books b ON mm.book_id = b.id
                      WHERE b.genre = 'Romance'
                      ORDER BY b.publication_date limit 1;";
        Query query = em.createNativeQuery(sql);
        rs =  query.getResultList();

        member = new Member();
        member.setMemberId(rs.getString("MemberId"));
        book.setName(rs.getString("name"));
        book.setMembershipDate(rs.getString("membership_date"));

        return member;
    }

    public findMembers() {
        String sql = "SELECT r.*
                      FROM members m
                      LEFT JOIN member_books s ON s.member_id = m.id
                      WHERE s.member_id_id IS NULL
                      WHERE m.membership_date  >= membership_date '2013-01-01'
                                   AND membership_date < '2014-01-01';";
        Query query = em.createNativeQuery(sql);
        rs =  query.getResultList();

       List<Member> members = new ArrayList<Member>();

       while(rs.next()) {
           Member member = new Member();
           member.setMemberId(rs.getString("MemberId"));
           member.setName(rs.getString("name"));
           member.setDate(rs.getString("membership_date "));
           members.add(book);
       }

       return books;
    }

}