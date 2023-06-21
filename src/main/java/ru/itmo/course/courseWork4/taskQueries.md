1. Получить название гор, на которые уже состоялись восхождения:
``` java
String sqlQuery1 = "SELECT DISTINCT m.name " +
                   "FROM mountains m " +
                   "JOIN climbing_groups cg ON cg.mountain_id = m.id";

```

2. Получить название гор, на которые не было ни одного восхождения:
``` java
String sqlQuery2 = "SELECT m.name " +
                   "FROM mountains m " +
                   "LEFT JOIN climbing_groups cg ON cg.mountain_id = m.id " +
                   "WHERE cg.id IS NULL";

```

3. Получить имена альпинистов, которые ходили в поход на гору с определенным названием:
``` java
String mountainName = "Название горы";
String sqlQuery3 = "SELECT mt.full_name " +
                   "FROM mountaineers mt " +
                   "JOIN group_mountaineers gm ON gm.mountaineer_id = mt.id " +
                   "JOIN climbing_groups cg ON cg.id = gm.group_id " +
                   "JOIN mountains m ON m.id = cg.mountain_id " +
                   "WHERE m.name = '" + mountainName + "'";


```

4. Получить названия и высоту гор, восхождение на которые планируется в определенный интервал времени:
``` java
LocalDateTime startDate = LocalDateTime.of(2023, 6, 1, 0, 0);
LocalDateTime endDate = LocalDateTime.of(2023, 6, 30, 23, 59);

String sqlQuery4 = "SELECT m.name, m.height " +
                   "FROM mountains m " +
                   "JOIN climbing_groups cg ON cg.mountain_id = m.id " +
                   "WHERE cg.start_date >= '" + startDate + "' AND cg.end_date <= '" + endDate + "'";


```

5. Получить имена альпинистов, которые не записались в новые (время начала похода в будущем) группы:
``` java
LocalDateTime currentDateTime = LocalDateTime.now();

String sqlQuery5 = "SELECT mt.full_name " +
                   "FROM mountaineers mt " +
                   "LEFT JOIN group_mountaineers gm ON gm.mountaineer_id = mt.id " +
                   "LEFT JOIN climbing_groups cg ON cg.id = gm.group_id " +
                   "WHERE cg.start_date > '" + currentDateTime + "' OR cg.id IS NULL";


```
