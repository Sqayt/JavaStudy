package ru.ivanovds.designPatterns.creational.singlethon;

/*
 * 	Плюсы:
 * 		- Простой код
 * 		- Потокобезопасность
 * 		- Высокая производительность в многопоточной среде	
 * 
 * 	Минусы:
 * 		- Не ленивая иницализация
 */
//TODO Самый простой, для маленьких проектов пойдет
class SingletonEager {
	private static SingletonEager instance = new SingletonEager();
	
	private SingletonEager() {
		
	}
	
	public static SingletonEager getInstance() {
		return instance;
	}
}

/*
 * 	Плюсы:
 * 		- Ленивая инициализация
 * 	
 * 	Минусы:
 * 		- Не потока безопасна
 */
//TODO Неплохой вариант
class SingletonLazy {
	private static SingletonLazy instance;
	
	private SingletonLazy() {
		
	}
	
	public static SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		
		return instance;
	}
}

/* 
 * 	Плюсы:
 * 		- Ленивая инициализация
 * 		- Потокобезопасность
 * 	
 * 	Минусы:
 * 		- Низкая производительность в многопоточной среде
 */

//TODO Самый приятный на вид
class SyncSingletonVer1 {
	private static SyncSingletonVer1 instance;
	
	private SyncSingletonVer1() {
		
	}
	
	public static synchronized SyncSingletonVer1 getInstance() {
		if (instance == null) {
			instance = new SyncSingletonVer1();
		}
		return instance;
	}
}

/* 
 * 	Плюсы:
 * 		- Ленивая инициализация
 * 		- Потокобезопасность
 * 		- Высокая производительность в многопоточной среде
 * 	
 * 	Минусы:
 * 		- Не подерживается в версиях java 1.5 (java 5), раньше ставилась volitale
 */
//TODO Считается самым лучшим вариантом
class SyncSingletonVer2 {
	private static SyncSingletonVer2 instance;
	
	private SyncSingletonVer2() {
		
	}
	
	public static synchronized SyncSingletonVer2 getInstance() {
		if (instance == null) {
			synchronized (SyncSingletonVer2.class) {
				if (instance == null) {
					instance = new SyncSingletonVer2();
				}
			}
		}
		return instance;
	}
}

/*
 * 	Плюсы:
 * 		- Ленивая инициализация
 * 		- Потокобезопасность
 * 		- Высокая производительность в многопоточной среде
 * 
 * 	Минусы:
 * 		- Может вызвать exceptions(ExceptionInInitializerError и NoClassDefFoundError)
 */
//TODO Самый странный, редко бы им пользовался бы (или никогда)
class HolderSingleton {
	
	private HolderSingleton() {
		
	}
	
	private static class SingletonHolder {
		public static final HolderSingleton HOLDER_INSTANCE = new HolderSingleton();
	}
	
	public static HolderSingleton getInstance() {
		return SingletonHolder.HOLDER_INSTANCE;
	}
}

/*
 *	Шаблон Singleton - это один из простых шаблонов в Java. Его суть заключается в создании одного единственного 
 *	и предоставляет доступ к нему.
 */

public class SingletonPattern {
	public static void main(String[] args) {
		SingletonEager singletonEager = SingletonEager.getInstance();
		System.out.println(singletonEager);
		
		SingletonLazy singletonLazy = SingletonLazy.getInstance();
		System.out.println(singletonLazy);
		
		SyncSingletonVer1 singletonVer1 = SyncSingletonVer1.getInstance();
		System.out.println(singletonVer1);
		
		SyncSingletonVer2 singletonVer2 = SyncSingletonVer2.getInstance();
		System.out.println(singletonVer2);
		
		HolderSingleton holderSingleton = HolderSingleton.getInstance();
		System.out.println(holderSingleton);
	}
	
}
