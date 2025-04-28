# Event Management System

This project is designed to apply Object-Oriented Programming (OOP) concepts, focusing on classes, method overloading, exception handling, and the Filter/Criteria design pattern. It is a project for the **MC322 - OOP** class at **UNICAMP**.

## Key Concepts

- **Class Modification & Collections:** Update the `Cliente` class to manage a list of tickets.
- **Method Overloading:** Implement overloaded methods for event creation, ticket management, and location searching.
- **Exception Handling:** Implement custom exceptions for managing errors in ticket sales, location allocation, and cancellations.
- **Filter/Criteria Pattern:** Create a generic `Filter` interface for event searching with different filters (e.g., by name, location, date).
- **Notifications:** Implement an email notification system that can be easily extended.
- **Comparable Interface:** Implement the `Comparable` interface to compare clients based on tickets for the same event.
- **Event Characteristics:** Refactor event classes to use composition for adding specific event types (e.g., bar event, live music).
- **Unit Testing:** Add unit tests for new features and error handling.

## Classes

- **Cliente:** Manages tickets (`List<Ingresso>`), with methods to add, remove, and retrieve tickets.
- **Ingresso:** Represents a ticket for an event.
- **Organizadora:** Manages events and supports method overloading for creating different event types.
- **Evento:** Abstract class for an event, with specific types like `EventoFestival`, `EventoShow`, etc.
- **Local:** Represents a venue with a name and capacity.
- **ImobiliariaDeEventos:** Manages a list of venues.
- **EMail:** Implements notifications through email.

## Key Features

- **Event Search with Filters:** Use the Filter/Criteria pattern to search for events based on various filters.
- **Exception Handling:** Handle custom exceptions such as `IngressoEsgotadoException` and `LocalIndisponivelException`.
- **Event Characteristics:** Add specific event types through composition and extend the system easily.
- **Notifications:** Implement the `Notificavel` interface for extensible notification handling.

## Activities

1. **Update the Cliente class** to manage tickets.
2. **Method overloading** for creating events, adding/removing tickets, and searching for venues.
3. **Handle exceptions** in event and ticket operations.
4. **Implement the Filter/Criteria design pattern** for event searches.
5. **Implement a Notification system** with extensibility in mind.
6. **Implement Comparable** for comparing clients.
7. **Extend event types** using composition (e.g., `EventoEmBar` and `EventoMusicaAoVivo`).
8. **Unit tests** for implemented features.
