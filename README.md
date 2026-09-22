# Animal Shelter Management System

A Java console application for managing an animal shelter, recording animals in a local database, tracking adoption status, and assigning volunteers with matching care skills.

## Overview

This project models a small shelter workflow where animals are grouped by category, stored in a text database, and handled through a simple menu-driven interface. It includes:

- animal records for aerial, aquatic, and terrestrial species
- database storage and lookup logic
- adoption and removal workflows
- volunteer skill validation for care tasks
- validation for incomplete or invalid animal entries
- a basic test runner for core behavior

## Features

- Manage a shelter database with animal records and IDs
- List animals from the saved database
- Add animals to the shelter record
- Remove animals after adoption or update
- Validate required animal fields before insertion
- Categorize species by type: aerial, aquatic, terrestrial
- Assign care tasks to volunteers based on their skills
- Run a simple built-in test suite for the project logic

## Project structure

```text
Animal_Shelter_Management_System/
├── app/
│   └── AnimalShelterApp.java
├── data/
│   └── treatment/
│       ├── DataBase.txt
│       ├── dataCollection.java
│       ├── dataTester.java
│       ├── InvalidEntryException.java
│       ├── Storable.java
│       └── WrongDataFormat.java
├── exception/
│   ├── ShelterException.java
│   └── InvalidEntryException.java
├── model/
│   ├── animals/
│   │   ├── Animal.java
│   │   ├── AnimalDescription.java
│   │   ├── aerials/
│   │   │   ├── AerialAnimal.java
│   │   │   └── species/
│   │   │       ├── Chiken.java
│   │   │       ├── Dodo.java
│   │   │       ├── Quetzalcoatlus.java
│   │   │       ├── Shoebill.java
│   │   │       └── WedgetailEagle.java
│   │   ├── aquatics/
│   │   │   ├── AquaticAnimal.java
│   │   │   └── species/
│   │   │       ├── Magnapinna.java
│   │   │       ├── MantisShrimp.java
│   │   │       ├── SnappingTurtle.java
│   │   │       ├── WhaleShark.java
│   │   │       └── YetiCrab.java
│   │   └── terrestrials/
│   │       ├── TerrestrialAnimal.java
│   │       └── species/
│   │           ├── BalistaSpider.java
│   │           ├── BengalTiger.java
│   │           ├── Human.java
│   │           ├── JavaRhinoceros.java
│   │           └── KomodoDragon.java
│   └── persons/
│       ├── Person.java
│       ├── adopters/
│       │   └── Adopter.java
│       └── volunteers/
│           └── Volunteer.java
├── repository/
│   └── MenuOption.java
├── service/
│   ├── AdoptionService.java
│   └── CareTask.java
├── test/
│   └── Test.java
├── Animals.md
├── ClassDiagram.md
├── LICENSE
├── README.md
└── app
```

## Requirements

- Java JDK installed and available on your PATH
- A terminal or command prompt

## Getting started

From the project root, compile all Java classes into an output directory:

### Windows PowerShell

```powershell
javac -d out (Get-ChildItem -Recurse -Filter *.java | Select-Object -ExpandProperty FullName)
```

### macOS/Linux

```bash
find . -name "*.java" -print | xargs javac -d out
```

Then run the application:

```powershell
java -cp out app.AnimalShelterApp
```

## Application menu

The application presents a command-line menu with the following options:

1. List animals
2. Adopt an animal
3. Add an animal
4. Run the built-in test suite
5. Exit the program

The main entry point is located in:

- `app/AnimalShelterApp.java`

## Testing

The project includes a basic test class in `test/Test.java`.

Compile the project as above, then run:

```powershell
java -cp out test.Test
```

This test exercises the volunteer care logic and a few representative animal objects.

## Data model

The project keeps animal data in the `data/treatment/DataBase.txt` file. Animal records are parsed and written through helper classes in the `data.treatment` package, while validation rules live in exception handling and the model classes.

The core model includes:

- `Animal` as the abstract base class
- `AerialAnimal`, `AquaticAnimal`, and `TerrestrialAnimal` specialized types
- `Volunteer` and related person classes
- `CareTask` for care assignment checks
- `MenuOption` for the main console menu

## Notes on the design

This project is intentionally a small demonstration of Java object-oriented design:

- the app is menu-driven and text-based
- data is stored in a flat text file instead of a database engine
- animal validation is centralized at the `dataCollection` layer
- volunteer matching relies on skill checks before care is assigned

## License

This project is licensed under the GNU General Public License v3.0. See the [LICENSE](LICENSE) file for details.