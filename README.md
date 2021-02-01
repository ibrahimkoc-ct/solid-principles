## Solid Principles

#### S ingle responsibility principle (SRP)
#### O pen/Closed Principle(OCP)
#### L iskov substitution principle (LSP)
#### I nterface segregation principle (ISP)
#### D ependency injection principle (DIP)

#### 1. Single responsibility principle (SRP)
>Tek sorumluluk anlamına gelen bu kuralın amacı projede bir değişiklik yapılmak istendiğinde buna bağlı olarak nelerin etkileneceği düşüncesinden kurtulmak ve özgürce isteğimiz geliştirmeyi yapabilmemize olanak sağlamaktır. 

* Aşağıdaki kod ise “Customer” sınıfı 2 sorumluluk alıyor, biri müşterilerin servis işlemlerinin sorumluluğunu üstleniyor, diğeri ise müşterilerin parametrelerini oluşturuyor.
Customer sınıfı, servis işlemlerinin sorumluluğunu üstlenmemelidir, çünkü müşteriler farklı bir servis methodu oluşturulmak istenildiğinde bu class’ın değiştirilmesi gerekecektir.
       
        public class Customer {
            private int id;
            private String name;
            private String surname;
            
        
            public String addCustomer(Customer customer) {
                return "add Customer";
            }
            
            
            public String deleteCustomer(int id) {
                return "deleted Customer";
            }
            
            public String updateCustomer(Customer customer) {
                return "update Customer";
            }
            
            public List<Customer> ListCustomer() {
                
                Customer customer= new Customer();
                List<Customer> customers= new ArrayList<Customer>();
                customers.add(customer);
                return customers;
            }
            
        }
* Aşağıda bulunan Single responsibility principle uyan kod ise her bir class ve method sadece kendisine verilen işi yapar.Böylece zaman içerisinde geliştirme yaparken etkilenecek diğer aşamaları gözden kaçırmanız gibi bir risk oluşmaz.

Customer Entity

        public class Customer {
            private int id;
            private String name;
            private String surname;
            public int getId() {
                return id;
            }
            public void setId(int id) {
                this.id = id;
            }
            public String getName() {
                return name;
            }
            public void setName(String name) {
                this.name = name;
            }
            public String getSurname() {
                return surname;
            }
            public void setSurname(String surname) {
                this.surname = surname;
            }
        }
Customer Service
   
    public class CustomerServiceImpl implements CustomerService{
    
    	@Override
    	public String addCustomer(Customer customer) {
    		return "add Customer";
    	}
    
    	@Override
    	public String deleteCustomer(int id) {
    		return "delete Customer";
    	}
    
    	@Override
    	public String updateCustomer(Customer customer) {
    		return "update Customer";
    	}
    
    	@Override
    	public List<Customer> listCustomer() {
    		Customer customer= new Customer();
    		List<Customer> customers= new ArrayList<Customer>();
    		customers.add(customer);
    		return customers;
    	}
    }        
        
#### 2. Open / Closed Principle (OCP)
>“Sınıflar değişikliğe kapalı ancak gelişime açık olmalıdır.” 
* Sınıflarımız veya metotlarımızı oluştururken ileride olabilecek yeni istekler ve gelişmeleri de öngörerek tasarlamamız gerekir. Projemizde oluşabilecek yeni istek ve ihtiyaçlar sonucunda yapacağımız geliştirmeler, projemizdeki diğer sistemleri etkilememeli ve herhangi bir değişikliğe sebebiyet vermemelidir.
* Aşağıdaki kod ise ‘enum type’a göre işlem yapan bir Logger sınıfımız ve onun içerisinde Log metodu mevcut. Bu durumda yeni bir log eklemek istediğimiz zaman enum ve Logger sınıflarımızda degişiklik yapmamız gerekecek

Logger

    public class Logger {
    	private XmlLog xmlLog;
    	private DbLog dbLog;
    	
    	
    	public void Log(LogType type,String value) {
    		if(type==LogType.Xml) {
    			xmlLog.Log(value);
    		}
    		else if(type==LogType.Db) {
    			dbLog.Log(value);
    		}
    	}
    }
DbLog
    
    public class DbLog {
    
    	public boolean Log(String value) {
    		return true;
    	}
    
    }
XmlLog
    
    public class XmlLog {
    
    	public boolean Log(String value) {
    		return true;
    	}
    }
    
LogType
    
    public enum LogType {
    	Xml,
    	Db
    }

* Kodun OCP uygun hali ise aşağıdaki gibidir.

ILogger
    
    public interface ILogger {	
    	public boolean Log(String value);
    }

DbLog

    public class DbLog implements ILogger{
    
    	@Override
    	public boolean Log(String value) {
    		return true;
    	}
    }

XmlLog

    public class XmlLog implements ILogger{
    
    	@Override
    	public boolean Log(String value) {
    		return true;
    	}
    }
Logger

    public class Logger {
    	private ILogger logger;
    	
    	public void Log(String value) {
    		logger.Log(value);
    	}
    }    
         
#### 3. Liskov’s Substitution Principle (LSP)    
> Kodlarımızda herhangi bir değişiklik yapmaya gerek duymadan alt sınıfları, türedikleri(üst) sınıfların yerine kullanabilmeliyiz.
* Alt sınıflar türetildikleri sınıfların nesneleriyle yer değiştirdiğinde aynı davranışı sergilemeli yani türetildikleri sınıfın tüm özelliklerini kullanmalıdır. Bu prensip bize base classlarda gereksiz kodların olmaması gerektiğini söyler
* Aşağıdaki kod ise Player sınıfından türeyen iki sınıfımız olsun ve bu sınıfta KickTheBall ve KeepTheBall adında iki metod olsun. Burada prensip uygulanmaz ise base class da gereksiz kodlar bulunacak.     
Player

      public abstract class Player {
        	
        	public String kickTheBall() {
        		return "kick the ball";
        	}
        	
        	public String keepTheBall() {
        		return "keep the ball";
        	}
        }
GoalKeeper

    public class Goalkeeper extends Player{
    
    	@Override
    	public String kickTheBall() {
    		return super.kickTheBall();
    	}
    
    	@Override
    	public String keepTheBall() {
    		return super.keepTheBall();
    	}
    }

Striker

    public class Striker extends Player{
    
    	@Override
    	public String kickTheBall() {
    		return super.kickTheBall();
    	}
    }        
        
* Görüldüğü gibi burada striker aslında ihtiyaç duymadığı KeepTheBall metodunu barındırmakta ve normal şartlarda bu fonksiyonu kullanamayacak, bu fonksiyonda exception fırlatması gerekecektir. Yani aslında gereksiz bir kod kalabalığı ve kod yönetimi açısından ek bir efor oluşacaktır, bunun nedeni base classda aslında gereksiz bir metod bulunmasıdır. Aşağıdaki gibi bir yapı kurulması LSP 'ye uygun olacaktır. 

IKeepTheBall

    public interface IKeepTheBall {
    	public String keep();
    }
Player

    public abstract class Player {
    	
    	public String kickTheBall() {
    		return "kick the ball";
    	}
    }  
GoalKepper

    public class Goalkeeper extends Player implements IKeepTheBall{
    
    	@Override
    	public String kickTheBall() {
    		return super.kickTheBall();
    	}
    
    	@Override
    	public String keep() {
    		return "keep the ball";
    	}
    
    }
    
Striker

    public class Striker extends Player {
    
    	@Override
    	public String kickTheBall() {
    		return super.kickTheBall();
    	}
    }
        
#### 4.Interface Segregation Principle (ISP)
>“Ara yüzlerin ayrılması prensibi”
 * ISP, temel amacı ara yüz implementation sonucunda oluşacak gereksiz kodları önlemek ve kodumuzun daha amaca yönelik hale gelmesini sağlamaktır.      
    Eğer interfacelerin tüm metodları implemente edilen sınıfta kullanılmıyorsa interfaceleri bölmek gerekir.
 * Aşağıdaki kod ise ISuperHero interfacesinden türeyen Batman ve SuperMan sınıflarımız olsun.Bu interface de Costume,Power,BatMobile ve Fly adında 4 metod bulunsun.
 
ISuperHero

    public interface ISuperHero {
    
    	  public String Costume();
    	  public String Power();
    	  public String BatMobile();
    	  public String Fly();
    }

Superman

    public class SuperMan implements ISuperHero {
    
    	@Override
    	public String Costume() {
    		return "My Costume is red and blue";
    
    	}
    
    	@Override
    	public String Power() {
    		return "I am from Krypton. Is that enough? ";
    	}
    
    	@Override
    	public String BatMobile() {
    		return "I can not use BatMobile";
    	}
    
    	@Override
    	public String Fly() {
    		return "I can fly";
    	}
    
    }

Batman

    public class Batman implements ISuperHero {
    
    	@Override
    	public String Costume() {
    		return "My Costume is dark";
    	}
    
    	@Override
    	public String Power() {
    		 return "My power is my money ";
    	}
    
    	@Override
    	public String BatMobile() {
    		return "I can use BatMobile";
    	}
    
    	@Override
    	public String Fly() {
            return "I can fly";
    
    	}
    }
    
*  İkisi de kostüm kullanır,güçleri vardır ama batman uçamaz ve süperman batmobile kullanmaz. O yüzden interfaceler ayrıştırılarak aşağıdaki hale getirilir. Böylece interfacelerde gereksiz özellikler barındırılmamış olur ve kod DIP uygun olacaktır.

ISuperHero

    public interface ISuperHero {
    
    	public String Costume();
        public String Power();
    }

IBatMobile

    public interface IBatMobile {
    	public String UseBatMobile();
    }

IFly

    public interface IFly {
    	public String FlyToSomeWhere();
    }

Batman

    public class Batman implements IBatMobile,ISuperHero{
    
    	@Override
    	public String UseBatMobile() {
        return "I can use BatMobile";
    
    	}
    
    	@Override
    	public String Costume() {
    		 return "My power is my money :D ";
    	}
    
    	@Override
    	public String Power() {
            return "My Costume is dark";
    
    	}
    }

Superman

    public class SuperMan implements ISuperHero, IFly {
    
    	@Override
    	public String Costume() {
    		return "My Costume is red and blue";
    
    	}
    
    	@Override
    	public String Power() {
    		return "I am from Krypton. Is that enough? ";
    
    	}
    
    	@Override
    	public String FlyToSomeWhere() {
    		return "I can fly";
    
    	}
    }

#### 5. Dependency Inversion Principle (DIP)
> Robert C. Martin’in Dependency Inversion Prensibi’ne göre;
>  * Üst seviye (High-Level) sınıflar alt seviye (Low-Level) sınıflara bağlı olmamalıdır, ilişki abstraction veya interface kullanarak sağlanmalıdır,
> * Abstraction(soyutlama) detaylara bağlı olmamalıdır, tam tersi detaylar abstraction(soyutlama)’lara bağlı olmalıdır.

* Genel olarak geliştirilen uygulamalarda, üst seviyeli işlem yapan metodlar alt seviyeli işlem yapan metodlara bağımlıdır. Yani o metodları çağırırlar. Bu durum iyi değildir. Çünkü, alt seviye işlem yapan metodlar alt seviyede bulunan metodlar değişiklik gerektireceğinden dolayı, üst seviye metodlar da değişikliğe uğramak zorunda kalır.  
 Yani yapılan küçük bir değişikliği başka bir projede tekrar kullanmak istediğimizde birçok sınıfı projeye referans vermek zorunda kalırız. Bu aslında bir tekrar kullanabilirlik değildir çünkü herhangi bir soyutlama olmadığı için modülerlikten de söz edilemez.
 * Aşağıdaki kod ise Production üst seviye sınıftır. Car ise alt seviye sınıftır. Dolayısıyla Production sınıfı’ı içerisindeki production metodu içindeki işlemler Car class’ındaki assemble metoduna bağlıdır. Car class’ındaki metodlarda yapılacak olan değişiklikler üst class’ı da etkilemektedir. Yani, Car class’ına herhangi bir metod eklediğimizde gerektiğinde yine Production class’ındaki production metodunda da metod eklememiz gerekecektir. Yine bir bağımlılık söz konusudur. Dolayısıyla, bu durum Dependency Inversion Prensibi’ne aykırıdır.  
 
 Production
 
    public class Production {
    	
    	public void production() {
    		Car car = new Car();
    		car.assemble();
    	}
    }

Car

     public class Car {
     
     	public boolean assemble() {
     		return true;
     	}
     }

* Olması gereken durum ise sınıflar arasındaki bağımlılıkları kaldırarak değişikler yapıldığı zaman başka bir sınıfın etkilememesini sağlamaktır. Üretimden sorumlu ProductManager class’ımızı oluşturuyoruz ve bu class’ımızı IProducton interface’ine bağlı hale getiriyoruz. Böylece IProduction interface’inden implement olmuş tüm class’lar ProductManager tarafından kullanılabilecektir.
    
IProduction

    public interface IProduction {
    	public boolean assemble();
    }

Car

    public class Car implements IProduction{
    
    	@Override
    	public boolean assemble() {
    		return true;
    	}
    }
  
ProductManager

    public class ProductManager {
    	
    	private IProduction production;
    
    	public ProductManager(IProduction production) {
    		
    		this.production = production;
    	}
    
    }
  
    
    
    
    
##### Kaynaklar
* https://medium.com/pirilab/soli%CC%87d-prensipleri-2-ec74fdf46964
* http://enesaysan.com/software/orneklerle-solid-prensipleri/
* https://medium.com/bili%C5%9Fim-hareketi/solid-nedir-ne-de%C4%9Fildir-12c8bdfeda1c    
    
        
        
