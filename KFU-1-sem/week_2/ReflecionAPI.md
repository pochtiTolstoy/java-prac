* Рефлексия - это механизм исследования данных о программе во время её выполнения. Рефлексия позволяет исследовать информацию о полях, методах и конструкторах классов.
* Помогает создавать корректный динамический код.

## Возможности рефлексии:
* Узнать/определить класс объекта.
* Получить информацию о модификаторах класса, полях, методах, константах, конструкторах и суперклассах
* Выяснить, какие методы принадлежат реализуемому интерфейсу
* Создать экземпляр класса, причем имя класса неизвестно до момента выполнения программы.
* Получить и установить значение поля объекта по имени
* Вызывать метод объекта по имени

## Практика
```java
public class MyClass {
  private int number;
  private String name = "default";
  // КТР не объявлен
  public int getNumber() { return number; }
  public void setNumber(int number) { this.number = number; }
  public void setName(String name) { this.name = name; }
  private voie printData() { System.out.println(number + name); }
}
```
* Для `name` не геттера. Можно было бы его дописать, но что если `MyClass` находится в скомпилированной библиотеке или в другом закрытом модуле без доступа к редактированию.
* Можно попробовать добраться до `name`:
```java
public static void main(String[] args) {
  MyClass myClass = new MyClass();
  int number = MyClass.GetNumber();
  String name = null; // no getter
  System.out.println(number + name);
  try {
    Field field = myClass.getClass().getDeclaredField("name");
    field.setAccessible(true);
    name = (String) field.get(MyClass);
  } catch (NoSuchFieldException | IllegalAccessException e) {
     e.printStackTrace(); 
  }
  sout(number + name);
}
```
* В java есть класс `Class`, который помогает вытаскивать информацию о других классах. Нужно вызвать метод `getFields()`. Он вернет все доступные поля класса. Но наше поле `private`, поэтому нужно пользоваться `getDeclaredFields()`. В качестве параметра передаем имя поля как `String`.
* Важное замечание: Эти методы не возвращают поля класса-родителя.
* `setAccessible(true)` - позволяет нам работать с этим полем.
* Можно вызвать `get(Object)`, чтобы получить конкретное значение этого поля у конкретного объекта.
## Setter
* Если у нас не оказалось setter'а для нашего поля, то можно использовать метод `set`:
```java
field.set(myClass, (String) "new value");
```
## Private method:
* Чтобы вытащить private метод можно использовать следующий код:
```java
public static void printData(Object myClass) {
  try {
    Method method = myClass.getClass().getDeclaredMethod("printData");
    method.setAccessible(true);
    method.invoke(myClass);
  } catch (NoSuceMethodException | InvocationTargetException | IllegalAccessException e) {
     e.printStackTrace(); 
  }
}
```
* Тоже самое, только тееперь для вызова метода нудно использовать `invoke(Object, ARGS)`.
* Теперь можно использовать нашу функцию:
```java
public static void main(String[] args) {
  MyClass myClass = new MyClass();
  int number = myclass.getNumber*()
  String name = null;
  printData(myClass);
  try {
    Field field = myClass.getClass().getDeclaredField("name");
    field.setAccessible(true);
    field.set(myClass, (String) "new value");
    name = (String) field.get(myClass);
  } catch (NoSuchFielException | IllegalAccessException e) {
    e.printStackTrace();
  }
  printData(myClass); // output 0new value
}
```
* рефлексия позволяет создавать экземпляры класса в режиме runtime. Можно создать объект класса по полному имени этого класса. Полное имя класса = имя класса + путь к нему в `package`
* Имя класса можно узнать:
```java
MyClass.class.getName();
```

* Создание класса с помощью рефлексии:
```java
public static void main(String[] args) {
  MyClass myClass = null;
  try {
    Class clazz = Class.forName(MyClass.class.getName()) ;
    MyClass = (MyClass) clazz.newInstance();
  } catch (/* ... */) {
  
  }
  sout(myClass); // Object reflection
}
```
* На момент старта java программы не все классы оказываются загруженными в JVM. Если в коде нет обращения к классу, то `ClassLoader` никогда его туда и не загрузит. ПОэтому нужно заставить `ClassLoader` загрузить его и получить описание нашего класса в виде переменной типа `Class`. Для этого есть `forName`. Вызов метода `newInstance()` вернет `Object`, который будет создан по тому самому описанию. Остается лишь только привести его к `MyClass`. 
* То есть фактически мы научились создавать объект всего лишь из одной строки. 
* Но такой способ будет лишь только работать с КТРом по умолчанию

## КТРы с параметрами
* Если в реализации нашего класса создать ктр с параметрами, то  `newInstance` перестанет работать.
* Тогда нужно переписать создание класса:
```java
public static void main(String[] args) {
  MyClass myClass = null;
  try {
    Class clazz = Class.forName(MyClass.class.getName());
    Class[] params = {int.class, String.class};
    myClass = (MyClass) clazz.getConstructor(params).newInstance(1, "default2");
  } catch () {
  
  }
}
```
* Для получения ктров у класса следует у описания класса вызвать метод `getConstructor()`, а для получения параметров ктра - `getParameterTypes()`
```java
Constructor[] ctrs = clazz.getConstructors();
for (Constructor ctr: ctrs) {
  Class[] paramTypes = ctr.getParameterTypes();
  for (Class paramType : paramTypes) {
    sout(paramType.getName() + " ");
  }
}
```
* Получаем все ктры и параметры к ним
* Нужно быть осторожным в использовании рефлексии, так как она нарушает принципы ООП.
