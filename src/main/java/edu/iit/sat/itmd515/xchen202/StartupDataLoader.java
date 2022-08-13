/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd515.xchen202;

import edu.iit.sat.itmd515.xchen202.security.GroupService;
import edu.iit.sat.itmd515.xchen202.security.UserService;
import edu.iit.sat.itmd515.xchen202.security.domain.Group;
import edu.iit.sat.itmd515.xchen202.security.domain.User;
import edu.iit.sat.itmd515.xchen202.domain.Payment;
import edu.iit.sat.itmd515.xchen202.domain.Account;
import edu.iit.sat.itmd515.xchen202.domain.Machine;
import edu.iit.sat.itmd515.xchen202.domain.MachineType;
import edu.iit.sat.itmd515.xchen202.domain.PaymentType;
import edu.iit.sat.itmd515.xchen202.domain.Treadmills;
import edu.iit.sat.itmd515.xchen202.service.AccountService;
import edu.iit.sat.itmd515.xchen202.service.MachineService;
import edu.iit.sat.itmd515.xchen202.service.PaymentService;
import edu.iit.sat.itmd515.xchen202.service.TreadmillsService;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * author XCHEN202 date 03-01-2022 13:25 version V1.0 Lab6 desc
 */
@Startup
@Singleton
public class StartupDataLoader {

    private static final Logger LOG = Logger.getLogger(StartupDataLoader.class.getName());

    @EJB
    private AccountService accountService;

    @EJB
    private PaymentService paymentService;

    @EJB
    private MachineService machineService;

    @EJB
    private TreadmillsService treadmillsService;

    /**
     * EJB security service user-group
     */
    @EJB
    private UserService userService;
    @EJB
    private GroupService groupService;

    /**
     * empty constroct
     */
    public StartupDataLoader() {

    }

    /**
     *
     * In this lab. we will have the real situation. First time! We go to the
     * gym. The salesman will service you. Let you know the gym component. When
     * your decision became VIP for the gym. He will help activate the VIP card.
     */
    @PostConstruct
    private void postConstruct() {
        //Lab8 04-02-2022 23:29
        Group adminRole = groupService.read("ADMIN_ROLE");
        if (adminRole == null) {
            initSecurityUserRole();
        }

        //Three steps for lab6.
        /*
        (Step1) Activate the VIP card.
        You need to pay some money to activate the card.
        After the reception staff will operate the system. Help create an account and give you a real card. 
         */
        //The salesman was very happy. I have a deal.
        //The client was very exciting. I can get training.
        Payment p1 = new Payment();
        p1.setMoney(1999);
        p1.setType(PaymentType.Card);
        paymentService.create(p1);

        Account a = new Account();
        a.setUsername("user1");
        a.setExpired(LocalDate.now());
        a.setCreatedBy("user1");
        //payment for year card
        LocalDate expired = a.getExpired();
        expired = expired.plusYears(1);
        a.setExpired(expired);
        p1.setAccount(a);

        accountService.create(a);

        /*
        (Step2) Use the Intelligent treadmill machine
        Login to the Intelligent use you account. Every time your end your training. The machine will upload data to the system.
         */
        //system manager record the machine.
        Machine m1 = new Machine();
        m1.setName("（2019）Deluxe Edition");
        m1.setOperationDesk("LED Red screen");
        m1.setPower("3.0HP");
        m1.setSpeed("1.0-8 Gear");
        m1.setSize("1100*490mm");
        m1.setWeight("35/40kg");
        m1.setMachineType(MachineType.CHEAP);
        m1.setPrice(1799);
        machineService.create(m1);

        Machine m2 = new Machine();
        m2.setName("（2019）Supreme Edition");
        m2.setOperationDesk("LED Red screen");
        m2.setPower("3.0HP");
        m2.setSpeed("1.0-10 Gear");
        m2.setSize("1100*510mm");
        m2.setWeight("38/45kg");
        m2.setMachineType(MachineType.EXPENSIVE);
        m2.setPrice(1999);
        machineService.create(m2);

        //new client use treadmills machine.
        initTreadmillsData(a, m1);
        initTreadmillsData(a, m2);

        /*
        (Step3) Check treadmill training information
        Display all treadmills about your use situation.
        Get a ranking list of today.
         */
        LOG.info("Satisfying the OUTPUT requirement");
        //I don't know! MySql database table was empty! a.getId() is null
//        List<Treadmills> allRecord = treadmillsService.findAll();
//        LOG.info("Find All");
//        LOG.info("sort\t\tuseTime\t\tkcal\t\tusername\t\tmachine name");
//        for(int i = 0; i < allRecord.size(); i++){
//            Treadmills data = allRecord.get(i);
//            LOG.info((i+1) + " All data=====> " + data.getUseTime() + " : " + data.getKcal()+ " : " + data.getAccount().getUsername()+ " : " + data.getMachine().getName());
//        }

//        List<Treadmills> allRankingList = treadmillsService.rankingList();
//        LOG.info("All RankingList");
//        LOG.info("sort\t\tuseTime\t\tkcal\t\tusername");
//        for(int i = 0; i < allRankingList.size(); i++){
//            Treadmills ts = allRankingList.get(i);
//            int index = i+1;
//            LOG.info(index + " Personal data=====> " + ts.getUseTime() + " : " + ts.getKcal()  + " : " + ts.getAccount().getUsername());
//        }
        LOG.info("Satisfying the OUTPUT requirement");
    }

    private void initTreadmillsData(Account a, Machine m) {
        Treadmills t1 = new Treadmills();
        t1.setAltitude(0);
        t1.setKcal(900);
        t1.setMills(8);
        t1.setStartDate(LocalDate.now());
        t1.setUseTime("00:45:00");

        t1.setAccount(a);
        t1.setMachine(m);
        t1.setCreatedBy("user1");

        Treadmills t2 = new Treadmills();
        t2.setAltitude(0);
        t2.setKcal(700);
        t2.setMills(6);
        t2.setStartDate(LocalDate.now());
        t2.setUseTime("00:40:00");

        t2.setAccount(a);
        t2.setMachine(m);
        t2.setCreatedBy("user1");

        Treadmills t3 = new Treadmills();
        t3.setAltitude(0);
        t3.setKcal(300);
        t3.setMills(3);
        t3.setStartDate(LocalDate.now().minusDays(9));
        t3.setUseTime("00:15:00");

        t3.setAccount(a);
        t3.setMachine(m);
        t3.setCreatedBy("user1");

        Treadmills t4 = new Treadmills();
        t4.setAltitude(0);
        t4.setKcal(200);
        t4.setMills(1);
        t4.setStartDate(LocalDate.now().minusDays(7));
        t4.setUseTime("00:10:00");

        t4.setAccount(a);
        t4.setMachine(m);
        t4.setCreatedBy("user1");

        Treadmills t7 = new Treadmills();
        t7.setAltitude(0);
        t7.setKcal(500);
        t7.setMills(5);
        t7.setStartDate(LocalDate.now());
        t7.setUseTime("00:20:00");

        t7.setAccount(a);
        t7.setMachine(m);
        t7.setCreatedBy("user1");

        Treadmills t8 = new Treadmills();
        t8.setAltitude(0);
        t8.setKcal(870);
        t8.setMills(8);
        t8.setStartDate(LocalDate.now().minusDays(7));
        t8.setUseTime("00:42:12");

        t8.setAccount(a);
        t8.setMachine(m);
        t8.setCreatedBy("user1");

        Treadmills t9 = new Treadmills();
        t9.setAltitude(0);
        t9.setKcal(889);
        t9.setMills(8);
        t9.setStartDate(LocalDate.now().minusDays(9));
        t9.setUseTime("00:44:00");

        t9.setAccount(a);
        t9.setMachine(m);
        t9.setCreatedBy("user1");

        Treadmills t10 = new Treadmills();
        t10.setAltitude(0);
        t10.setKcal(870);
        t10.setMills(8);
        t10.setStartDate(LocalDate.now().minusDays(10));
        t10.setUseTime("00:45:00");

        t10.setAccount(a);
        t10.setMachine(m);
        t10.setCreatedBy("user1");

        treadmillsService.create(t1);
        treadmillsService.create(t2);
        treadmillsService.create(t3);
        treadmillsService.create(t4);
        treadmillsService.create(t7);
        treadmillsService.create(t8);
        treadmillsService.create(t9);
        treadmillsService.create(t10);
    }

    /**
     * Lab8 04-02-2022 23:29
     */
    private void initSecurityUserRole() {
        /**
         * Create a combination of three different situations
         */
        //create all roles
        Group coachGroup = new Group("COACH_GROUP", "This group represents coach in the security realm");
        Group userGroup = new Group("USER_GROUP", "This group represents user in the security realm");
        Group adminGroup = new Group("ADMIN_GROUP", "This group represents administrators in the security realm");
        Group findRole = groupService.read(coachGroup.getGroupName());
        groupService.create(coachGroup);
        groupService.create(userGroup);
        groupService.create(adminGroup);

        //2.Two roles situations
        User admin_Coach = new User("admin_Coach", "admin_Coach", true);
        admin_Coach.addGroup(coachGroup);
        admin_Coach.addGroup(adminGroup);

        User user_Coach = new User("user_Coach", "user_Coach", true);
        user_Coach.addGroup(coachGroup);
        user_Coach.addGroup(userGroup);

        //3.Simple role
        User admin1 = new User("admin1", "admin1", true);
        admin1.addGroup(adminGroup);

        User coach1 = new User("coach1", "coach1", true);
        coach1.addGroup(coachGroup);
        User user1 = new User("user1", "user1", true);
        user1.addGroup(userGroup);

        userService.createUser(admin_Coach);
        userService.createUser(user_Coach);
        userService.createUser(admin1);
        userService.createUser(coach1);
        userService.createUser(user1);
    }

}
