/*Задание
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, 
их необходимо считать, как одного человека с разными телефонами. 
Вывод должен быть отсортирован по убыванию числа телефонов.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
  public static  HashMap <String, ArrayList> contacts = new HashMap(); 

  public static void addContacts(String name, String phoneNumber) {
    if (contacts.containsKey (name)) {
      ArrayList phoneNumbers = contacts.get(name);
      phoneNumbers.add(phoneNumber);
      contacts.put(name, phoneNumbers);
    }
    else {
      ArrayList phoneNumbers = new ArrayList();
      phoneNumbers.add(phoneNumber);
      contacts.put(name, phoneNumbers);
    }
  }

  public static void showContacts() {
    ArrayList<Map.Entry<String, ArrayList>> list = new ArrayList(contacts.entrySet());
    Collection.sort(list, new Comparator<Map.Entry<String, ArrayList>>(){
      @Override
      public int compare(Map.Entry<String, ArrayList> o1, Map.Entry<String, ArrayList> o2) {
        return o2.getValue().size() - o1.getValue().size();
      }
    });

    for (Map.Entry<String, ArrayList> entry: list) {
      System.out.println(entry.getKey() + ":" + entry.getValue());
    }
  }
}