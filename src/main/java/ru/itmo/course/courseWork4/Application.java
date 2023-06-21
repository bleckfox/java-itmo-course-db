package ru.itmo.course.courseWork4;

import org.apache.commons.text.*;

import ru.itmo.course.courseWork4.entities.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        DatabaseManager dbManager = new DatabaseManager();

        List<Mountain> mountains = new ArrayList<>();
        List<Mountaineer> mountaineers = new ArrayList<>();
        List<ClimbingGroup> climbingGroups = new ArrayList<>();

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            Mountain mountain = new Mountain();
            mountain.setName("Mountain " + (random.nextInt(40)));
            mountain.setCountry("Country " + (random.nextInt(40)));
            mountain.setHeight((i + 1) * 1000);

            dbManager.MountainsOperations(mountain, "add", mountains);


            Mountaineer mountaineer = new Mountaineer();
            mountaineer.setFullName("Mountaineer " + (i + 1));
            mountaineer.setAddress("Address " + (i + 1));

            dbManager.MountaineerOperations(mountaineer, "add", mountaineers);


            ClimbingGroup climbingGroup = new ClimbingGroup();
            climbingGroup.setMountain(mountain);
            climbingGroup.setStartDate(LocalDateTime.now().minusDays(random.nextInt(40)));
            climbingGroup.setEndDate(LocalDateTime.now().plusDays(random.nextInt(50)));
            climbingGroup.setRecruiting(random.nextBoolean());
            climbingGroup.getMountaineers().add(mountaineer);

            dbManager.ClimbingGroupsOperations(climbingGroup, "add", climbingGroups);

        }

    }
}
