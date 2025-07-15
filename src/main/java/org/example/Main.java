package org.example;

import org.example.DAO.RegionDAO;
import org.example.Entity.Region;
import org.example.utils.ClimatEnum;
import org.hibernate.hql.internal.ast.ParseErrorHandler;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static RegionDAO regionDAO = new RegionDAO();
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        Region region = Region.builder().name("Rhône").surface(125000).climat(ClimatEnum.Préfascite).build();
        Region region2=Region.builder().name("Bretagne").surface(156452123).climat(ClimatEnum.Océanique).build();

            regionDAO.delete(2L);
    }



}