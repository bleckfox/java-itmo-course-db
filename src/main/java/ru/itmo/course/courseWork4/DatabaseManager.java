package ru.itmo.course.courseWork4;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.itmo.course.courseWork4.entities.*;

import java.util.List;

public class DatabaseManager {

    private final SessionFactory sessionFactory;

    public DatabaseManager(){
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Mountaineer.class);
        configuration.addAnnotatedClass(Mountain.class);
        configuration.addAnnotatedClass(ClimbingGroup.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    /**
     * Операции для таблицы Альпинистов
     * @param mountaineer Альпинист
     * @param operation Операция
     * @param mountaineers Список альпинистов
     */
    public void MountaineerOperations(Mountaineer mountaineer, String operation, List<Mountaineer> mountaineers){
        DbManagerHelper<Mountaineer> managerHelper = new DbManagerHelper<>(sessionFactory, Mountaineer.class);

        switch (operation){
            case "update" -> managerHelper.updateEntity(mountaineer);
            case "add" -> {
                managerHelper.addEntity(mountaineer);
                mountaineers.add(mountaineer);
            }
            case "delete" -> {
                managerHelper.deleteEntity(mountaineer.getId());
                mountaineers.remove(mountaineer);
            }
            case "get" -> {
                mountaineers.clear();
                mountaineers.add(managerHelper.getEntityById(mountaineer.getId()));
            }
            case "getAll" -> {
                mountaineers.clear();
                mountaineers.addAll(managerHelper.getAllEntities());
            }
        }
    }

    /**
     * Операции для таблицы Гор
     * @param mountain Гора
     * @param operation Операция
     * @param mountains Список гор
     */
    public void MountainsOperations(Mountain mountain, String operation, List<Mountain> mountains){
        DbManagerHelper<Mountain> managerHelper = new DbManagerHelper<>(sessionFactory, Mountain.class);

        switch (operation){
            case "update" -> managerHelper.updateEntity(mountain);
            case "add" -> {
                managerHelper.addEntity(mountain);
                mountains.add(mountain);
            }
            case "delete" -> {
                managerHelper.deleteEntity(mountain.getId());
                mountains.remove(mountain);
            }
            case "get" -> {
                mountains.clear();
                mountains.add(managerHelper.getEntityById(mountain.getId()));
            }
            case "getAll" -> {
                mountains.clear();
                mountains.addAll(managerHelper.getAllEntities());
            }
        }
    }

    /**
     * Операции для таблицы Группы восхождения
     * @param climbingGroup Группа восхождения
     * @param operation Операция
     * @param climbingGroups Список групп
     */
    public void ClimbingGroupsOperations(ClimbingGroup climbingGroup, String operation, List<ClimbingGroup> climbingGroups){
        DbManagerHelper<ClimbingGroup> managerHelper = new DbManagerHelper<>(sessionFactory, ClimbingGroup.class);

        switch (operation){
            case "update" -> managerHelper.updateEntity(climbingGroup);
            case "add" -> {
                managerHelper.addEntity(climbingGroup);
                climbingGroups.add(climbingGroup);
            }
            case "delete" -> {
                managerHelper.deleteEntity(climbingGroup.getId());
                climbingGroups.remove(climbingGroup);
            }
            case "get" -> {
                climbingGroups.clear();
                climbingGroups.add(managerHelper.getEntityById(climbingGroup.getId()));
            }
            case "getAll" -> {
                climbingGroups.clear();
                climbingGroups.addAll(managerHelper.getAllEntities());
            }
        }
    }

}
