
// WatsApp  
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

//---------------------------------------------------
// Программа CleanScaner   
//Документ получаемый при сканировании
class My_doc
{
  // Image foto
  // Data_Time
  int size;      
}
// Список всех имеющихся документов
class Doc_list
{
  // список файлов 
}
// Корзина для удалениф
class Basket
{
  // Image  ;
  // Массив файлов для удаления
} 

// Меню пользователя
class Menu
{
  // Кнопка1 
  // Кнопка2
  // КнопкаN
} 

//кнопка к которй должно быть привязано действие
class Knopka
{
  boolean state = false; //нажата,отжата 
  boolean allow = true; // Доступна или нет
  // Другие свойства
  // Действие по нажатии
}
// Пользовательсктй интерфейс - кнопки, меня, перемещение по экрану
class User_interface
{  
  // копка
  // меню
}
// Логика работы программы
 class User_Manager
{
 // управление логикой работы    
}

