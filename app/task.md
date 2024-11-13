## Задание 1.
Инициация проекта
## Задание 2.
Создание Singlton объекта, в проекте находится в package com.example.javapatternsproject.common.ui.theme.themeholder;
## Задание 3.
Создание Prototype в package com.example.javapatternsproject.common.usecase.pattern;
## Задание 4.
Создание StaticFabricMethod в package com.example.javapatternsproject.common.usecase.pattern;
## Задание 5.
Создание Builder в com.example.javapatternsproject.common.ui.theme.themeholder;
## Задание 6.
Создание Factory в com.example.javapatternsproject.common.sdk.intent
## Задание 7.
Создание Adapter в com.example.javapatternsproject.common.sdk.vibration,
SystemVibrator, VibrationManager, VibratorAdapter
## Задание 8.
Создание Abstract Factory в com.example.javapatternsproject.common.sdk.notification,
AndroidNotificationFactory, NotificationFactory, NotificationImpl
## Задание 9.
Создание Bridge в com.example.javapatternsproject.common.storage,
DataSaver, DataStorage, DebugDataStorage, DataStoreSaver, SharedPreferencesSaver
## Задание 10.
Создание Composite в com.examople.javapatternsproject.common.usecase.pattern.Content,
com.examople.javapatternsproject.common.usecase.pattern.Paragraph
## Задание 11.
Создание Decorator в com.example.javapatternsproject.common.sdk.resources.SystemResourcesProvider,
com.example.javapatternsproject.common.sdk.resources.ResourcesProvider
com.example.javapatternsproject.common.sdk.resources.decorator.LoggerResourceProviderDecorator
## Задание 12.
Создание Facade в [`RequestFacadeImpl`](./src/main/java/com/example/javapatternsproject/common/request/RequestFacadeImpl.java)
### Причина выбор
Паттерн фасад крайне удачно подходит для упрощения кода в данном примере, огромному количеству потенциальных
клиентов данного кода (все что требуют кэшируемую информацию) могут использовать фасад, вместо декларирования зависимотсей и дублирования логики$$
### Признаки паттерна
Класс [`RequestFacadeImpl`](./src/main/java/com/example/javapatternsproject/common/request/RequestFacadeImpl.java) польностью удовлетворяет своей структурой паттерну фасад
он явно зависит от 3 классов, и содержит в себе метод, который хранит логику использования этих 3 зависимостей, тем самым снимая эту отвественность с клиента.
## Задание 13.
Создание Facade в [`TextPresentationFactory`](./src/main/java/com/example/javapatternsproject/common/ui/text/textpresent/TextPresentationFactory.java)
### Причина выбора
Паттерн Flyweight здесь идеально подходит для того что бы переиспользовать строки, но нельзя переиспользваться Spannable строки, по этому они буду создавать каждый раз новые
## Задание 14
Создание Прокси в [`ExpandAnimation`](./src/main/java/com/example/javapatternsproject/common/ui/animation/Expand.java)
### Причина выбора
 некоторых сулчаях будет правильней не показывать Анимированные изменения UI, а показывать упрощенный вид с измнением состоянияя в 1 кадр
### Признаки паттерна
Классы реализуют один интерфейс ExpandAnimation и имеют тяжелую RealExpandAnimation и легкую реализацию ExpandAnimationProxy, и в некоторых случаях 
прокси-класс может вызывать методы проксируемого
## Задание 16
Создание Command в [`messagetouser`](./src/main/java/com/example/javapatternsproject/common/sdk/messagetouser)
### Причина выбора
Паттерн Command хорошо здесь подходит во-первых, с точки зрения отладки, можно показывать toast 
при дебаге, и по истории легко понимать их последовательнось, во-вторых мы можем множество разных видов
коммуникации описывать через фиксированный набор команд
### Признаки паттерна
Интерфейс команды - интерфейс с одним методом execute
Есть класс который отвечает за выполнение команд
Команды имеют внутри себя не обобщенное состояние и логику