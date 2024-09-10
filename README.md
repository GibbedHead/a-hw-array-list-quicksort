# Кастомная реализация ArrayList и QuickSort сортировки для него

## Проверка

* Клонировать репозиторий
* Запустить тесты

```bash
git clone https://github.com/GibbedHead/a-hw-array-list-quicksort.git;
mvn test;
```

## Результат

* Класс [MyArrayList.java](src%2Fmain%2Fjava%2Fru%2Fchaplyginma%2Flist%2FMyArrayList.java) - реализует почти все метода интерфейса List, кроме итераторов, подлиста и т.д.
* Класс [MyListSort.java](src%2Fmain%2Fjava%2Fru%2Fchaplyginma%2Fsort%2FMyListSort.java) - реализует алгоритм быстрой сортировки Хоара через 2 статических метода:
  * принимающий список и реализацию Comparator
  * принимающий список, где элементы реализуют интерфейс Comparable
* Класс [Person.java](src%2Fmain%2Fjava%2Fru%2Fchaplyginma%2Fmodel%2FPerson.java) - реализующий интерфейс Comparable и кастомную сортировку по нескольким полям для использования в тестах

## Тесты
* Класс [MyArrayListTest.java](src%2Ftest%2Fjava%2Fru%2Fchaplyginma%2Flist%2FMyArrayListTest.java) - тесты методов [MyArrayList.java](src%2Fmain%2Fjava%2Fru%2Fchaplyginma%2Flist%2FMyArrayList.java)
* Класс [MyListSortTest.java](src%2Ftest%2Fjava%2Fru%2Fchaplyginma%2Fsort%2FMyListSortTest.java) - тесты сортировки

### Задание

* Реализовать свой ArrayList (не потокобезопасный Методы - добавить элемент, получить элемент, удалить элемент, очистить всю коллекцию, отсортировать, остальное по желанию
* Реализовать алгоритм quicksort для реализованной вами реализации ArrayList. Ссылка на отличное описание работы алгоритма. Ваш QuickSort должен принимать ArrayList любого типа и сортировать его. Использовать: ○ Java generics ○ Comparable, Comparator
* Документировать код. Что, зачем и как  Все классы и интерфейсы должны быть задокументированы на уровне класса (class-level javadoc) Все публичные методы ваших реализаций должны содержать javadoc  Документация должна быть в полном объёме и представлять исчерпывающее и интуитивно понятное руководство пользования вашим кодом для другого разработчика 
