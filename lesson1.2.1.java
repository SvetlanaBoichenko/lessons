public class MainClass {
  public static void main(String[] args) { 
    
// Описание абонента, данные, список собеседников, список групп,
// список сообщений с каждым сосеседником, кнопка выхода, список звонков
// другие свойства
class Persona
{
  String name;    // имя
  String tel_num; // номер телефона
  String status;  //строка статуса
  String status;  // В сети - не в сети
  
  String[]calls;
  
  boolean alarm_message;
  boolean visible_state;
 // Image foto;

  String cur_message;    // еще не отправлено
} 

// Звонок
class call
{
  String data_time;// дата время звонка
  int type; // Вхдящий исходящий,пропущеный,отвеченый
}  
// Тип ообщения, максим длина, размер,получатели
class message 
{
  Srting mesage;
  int size;
  int max_size;
}

//собеседники
class hablador
{
  String name;    // имя
  String tel_num; // номер телефона
  String status;  //строка статуса
 
  boolean lock; // Заблокирован ли
  boolean alarm_mesage;// уведомлять ли

 // Image foto; 
 // список сообщений со мной - Persona 
}

//Чьи сообщения, кому от кого
class Message_manager
{
  boolean read_only;
  int max_message_count; 
  // Список собеседников hablador
  // 
}

// Тип ообщения, максим длина, размер,получатели - кому от кого
class message 
{
  int state; // Доставлено,прочитано или нет
  Srting mesage;  
}

class Person_manager 
{
  Persona [] all_persona_list;
  Persona [] favorit_persina_list; 
  Persona [] black_persons_list;
  // Другие поля
}

class knopka
{
  boolean state; //нажата,отжата 
  boolean allow; // Доступна или нет
  // Другие свойства
}

class User_interface
{  
  // копка
  // меню
}

  }
}
