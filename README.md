# Tasks-Todo-List app in Kotlin

# Project Overview 

### Technologies Used

- Language: Kotlin
- Architecture Pattern: MVC (Model-View-Controller)
- Android Frameworks: Android SDK, Android Jetpack
- UI Components: XML layout with Material Design components
- RecyclerView: Efficient display of tasks and tags
- Data Binding: Android Data Binding Library
- Version Control: Git
- Build Tool: Gradle


### Features

- User-friendly to-do list application with an intuitive interface.
- Recycler view for displaying both tasks and tags.
- Easy task addition with a category selection option.
- Stylish tags with selectable categories (Personal, Work, Shopping).
- Visual indication of selected tasks and tags.
- Seamless integration of Material Design components.

# Key Components 🛠️

### Adapters:

- **TagsAdapter:** Manages the tags displayed in the UI.
- **TagsViewHolder:** Handles the view representation for tags.
- **TasksAdapter:** Manages the tasks displayed in the UI.
- **TasksViewHolder:** Handles the view representation for tasks.

### Models:

- **Tags:** Represents categories for tasks (e.g., Personal, Work, Shopping).
- **Task:** Represents individual to-do tasks with a name, category (tag), and selection status.

### View:

- **MainActivity:** The main activity responsible for displaying tags, tasks, and handling user interactions. It serves as the "View" in the MVC structure.

## Key Features 🚀

- Users can add tasks with specific categories.
- Tasks are categorized into tags such as Personal, Work, and Shopping.
- The UI allows users to interact with tasks, marking them as completed or incomplete.

## Screenshots 📷

![SS1](/screenshots/2ndScreen.jpg)
![SS2](/screenshots/3rdScreen.jpg)
![SS3](/screenshots/4thScreen.jpg)
![SS4](/screenshots/mainScreen.jpg)


## Additional Notes 📝

While the project follows an MVC-inspired architecture, it offers flexibility and simplicity for a to-do list application. Future enhancements could explore adopting more structured patterns like MVVM (Model-View-ViewModel) for improved separation of concerns.
