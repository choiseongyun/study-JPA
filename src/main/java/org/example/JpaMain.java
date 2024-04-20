package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em =emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            /*Member findMember = em.find(Member.class,1L);
            findMember.setName("HelloJPA");*/
            //setName만 해줘도 update 쿼리가 날라간다.
            //em.remove는 삭제
            //entityManager는 스레드간에 공유해서는 안된다.

            //JPQL
            //Member란 Table이 아닌 객체 Member Entity를 바라보고 요청하는거다
            //그럼 이게 그냥 쿼리 요청하는거랑 뭔 메리트가 있냐??
            //setFirstResult 및 setMaxResults 를 사용해서 객체로 요청 가능
//            List findMembers = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//            //비영속
//            Member member = new Member();
//            member.setId(100L);
//            member.setName("HelloJPA");

            //영속
//            System.out.println("=== BEFORE ===" );
//            em.persist(member);
            //준영속
//            em.detach(member);
            //삭제
//            em.remove(member);
//            System.out.println("=== AFTER ===" );

//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("result = " + (findMember1 == findMember2));
//
//            //commit을 할 때만 쿼리가 날라간다.

            Member member1 = new Member(150L,"A");
            Member member2 = new Member(160L,"B");

            em.persist(member1);
            em.persist(member2);

            System.out.println(" ========== ");

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
