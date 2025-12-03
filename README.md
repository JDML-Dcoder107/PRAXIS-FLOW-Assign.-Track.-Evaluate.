# PRAXIS-FLOW-Assign.-Track.-Evaluate.

**Description**
The Praxis Flow system is a comprehensive internship and partnership management platform designed to connect students/interns, companies, schools, and administrators. Its primary function is to facilitate the entire internship lifecycle, from registration and task management to progress monitoring, evaluation, and establishing official partnerships.

##  OOP Concepts Applied

We applied the following OOP principles to ensure a robust and scalable architecture:

### **Inheritance** (Code Reusability)
Allows sub-classes to reuse methods from parent classes.
* **Classes Used:** `Student Intern`, `Company`, `School`, `AdminMain`
* **Inherited From:** `User`

### **Encapsulation** (Data Protection)
Bundles data and the methods that operate on it, limiting direct access to maintain integrity.
* **Classes Used:** `Evaluation`, `Internship`, `Task`, `TimeLog`, `StudentIntern`, `Company`, `AdminMain`, `School`

### **Polymorphism** (Flexible Behavior)
Allows objects to implement a common method differently, depending on their type.
* **Classes Used:** `Student Intern`, `Company`, `School`, `AdminMain`

### **Abstract Class and Interface** (Defining Contracts)
Ensures specific class and interfaces adhere to a mandatory set of methods.
* **Classes Used:** `User`, `Evaluate`, `Tracker`

##  Praxis Flow System Architecture

This document provides a precise overview of the class structure, user roles, and core relationships within the Praxis Flow application, built using Object-Oriented Programming (OOP) principles.

##  Main Class Structure Overview

The system is built on an Abstract Class, specialized Subclasses (User Roles), and Supporting Data Models to define a clear, scalable, and standardized architecture.

### 1.  Core Component Relationships

| Component | Role | Relationship |
| :--- | :--- | :--- |
| **Abstract Class: `User`** | Defines **common properties** (`userID`, `email`) and **base methods** (`login()`, `logout()`) shared by all users in the system. | **Inherited By** all Subclasses (`AdminMain`, `StudentIntern`, etc.). |
| **Interface (Contract)** | Defines a set of **methods** that all Subclasses *must* implement, enforcing **standardized behavior** across different user roles. | **Implemented By** 2 of the Subclasses (`Company`, and `StudentIntern`). |
| **Subclasses (User Roles)** | Represent the four distinct user roles, implementing **role-specific features** and managing relevant data. | **Inherit From** `User` and **Implement** the `Interface`. |
| **Supporting Data Models** | Fundamental data structures (`Task`, `Evaluation`, etc.) that hold specific program information. | **Used By** Subclasses, typically stored within their internal data arrays. |

---

### 2.  User Roles (Subclasses) and Features

These are the primary operational classes, each with unique features and internal data management capabilities (using internal arrays to store instances of the Data Models).

| Class Name | Inherits From | Key Role/Responsibilities | Data Models Managed |
| :--- | :--- | :--- | :--- |
| **`AdminMain`** | `User` | **System Oversight**: Approves internships, views all records, and manages user accounts (Delete User). | `Internship`, `LogHour`, `Evaluation`, `Task` |
| **`StudentIntern`** | `User` | **Program Participation**: Logs work hours, completes tasks, and views personal time sheets and evaluations. | `Task`, `LogHour`, `Evaluation` |
| **`Company`** | `User` | **Internship Management**: Creates internships, assigns tasks, submits evaluations, and manages partnerships. | `Internship`, `Task`, `Evaluation` |
| **`School`** | `User` | **Student Placement & Monitoring**: Recommends students, monitors progress (by date/hours), and views partnerships. | `Internship`, `LogHour` |

---

### 3.  Supporting Data Models

These classes are crucial for storing the data that flows through the system's operations.

| Class Name | Role/Description | Key Data Stored |
| :--- | :--- | :--- |
| **`Task`** | Defines a single assignment or work item. | Description, Status. |
| **`Evaluation`** | Stores an intern's performance review. | Performance scores, Feedback. |
| **`Internship`** | Defines the details of an open position. | Position definition, Required inputs. |
| **`LogHour`** | Records the time an intern has worked. | Hours worked, Date of work. |

## **How to Run the Progrram**
This guide provides a formal, user-friendly, and step-by-step procedure for utilizing the Praxis Flow system across the four designated user accounts: Student Intern, School Coordinator, Main Admin, and Company Mentor/Supervisor. Successful program operation requires sequential actions performed by different accounts.

**I. Account Logins and Initial Setup**

   The program operation begins with establishing the relationship between the participating organizations.

**Login as School Coordinator or Company Mentor/Supervisor:**

   The first step is for either a School Coordinator or a Company Mentor/Supervisor to log into their respective accounts.

**Establish Partnership:**

   Once logged in, the user must Establish or Add Partnership by linking a Company with a School (and vice versa) within the system.

**II. Internship Creation and Recommendation**

   After the partnership is established, the company initiates the internship listing, which the school then uses for student placement.

**Login as Company Mentor/Supervisor:**

   The Company Mentor/Supervisor must log in to their account.

**Create Internship:**

   Access the internship creation feature and fill in all required specific inputs to define the internship opportunity.

**Login as School Coordinator:**

   The School Coordinator must log in to their account.

**Recommend Student:**

   Navigate to the Recommend Student feature.
   Recommend an eligible student intern to the desired position created by the school’s partner company.
   
**III. Internship Approval and Activation**

The final activation of the internship requires the Main Admin approval.

**Login as Main Admin:**

   The Main Admin must log in to their account.
   The Main Admin has the authority to view all partnerships and users, as well as the power to delete users from the system.

**Approve Internship:**

   Locate the pending internship requests.
   Select if Approve or Reject Internship for the student/position pairing.

**Internship Activation:**

   Once the request is Approved, the intern's status becomes Active.
   The intern is then ready to receive tasks from the company and commence the program.

**IV. Post-Activation Features and Monitoring**

Once active, specific features become available for the intern and the company.

| User Account | Core Functionality | Unique/Designated Features | Oversight/Monitoring Capabilities |
| :--- | :--- | :--- | :--- |
| `Student Intern` | Completes tasks received from the company. | **`Time Log`** and **`View Timesheet`**. These are **only accessible** by the intern for personal tracking. | Views submitted **`Evaluation Scores`**. |
| `Company Mentor/Supervisor` | Submits tasks to the intern. | Submits formal **`Evaluation Scores`** for the intern's performance. | Monitors intern performance and task completion. |
| `School Coordinator` | None required in this phase. | None required in this phase. | Has the ability to **view the student's progress** (e.g., status, timesheets, scores). |
| `Main Admin` | System-wide management and control. | **`View all partnerships`**, **`View all users`**, and the power to **`Delete a user`** from the system. | Complete system-wide oversight and data access. |

## Sample Output

| Feature | Screenshot |
|--------|------------|
| Approved Internship 1 | <img src="OOP/Approve Internship 1 - AdminMain.png" width="300"> |
| Approved Internship 2 | <img src="OOP/Approve Internship 2 - AdminMain.png" width="300"> |
| Manage User (Delete) | <img src="OOP/Manage User (Delete) - Admin Main.png" width="300"> |
| View All User | <img src="OOP/View All User - AdminMain.png" width="300"> |
| View All User After Delete | <img src="OOP/View All User after Manage User(Delete).png" width="300"> |
| View All Partnership | <img src="OOP/View all Partnership - AdminMain.png" width="300"> |

| Feature | Screenshot |
|--------|------------|
| Established Partnership <br> (School → Company)| <img src="OOP/Established Partnership School to Company - School.png" width="300"> |
| Monitor Progress | <img src="OOP/Monitor Progress - School.png" width="300"> |
| Recommend Student | <img src="OOP/Recommend Student - School.png" width="300"> |
| View Internship <br> Recommendation | <img src="OOP/View Internship Recommendation - School.png" width="300"> |

| Feature | Screenshot |
|--------|------------|
| Complete Task | <img src="OOP/Complete Task - StudentIntern.png" width="300"> |
| Log Hours | <img src="OOP/Log Hours - StudentIntern.png" width="300"> |
| View Evaluation (1) | <img src="OOP/View Evaluation 2 - StudentIntern.png" width="300"> |
| View Evaluation (2) | <img src="OOP/View Evaluation 2 StudentIntern.png" width="300"> |
| View Timesheet | <img src="OOP/View Timesheet - StudentIntern.png" width="300"> |

| Feature | Screenshot |
|--------|------------|
| Main Screen – Starting Screen | <img src="OOP/Main Screen - Starting Screen.png" width="300"> |

##  Authors

* John Daniel Labiano
* John Greig Galarbe
* Joyce Cornel

##  Acknowledgements

We are grateful to our professor, Sir Emmanuel Charlie Enriquez, for their guidance and support.

##  Future Enhancements

We have identified the following key areas for future development to significantly improve the system's security, usability, and functionality.

---

### 1.  Comprehensive Graphical User Interface (GUI)

The current interface will be replaced with dedicated GUIs for each user subclass to provide a clearer, more efficient, and role-specific view of the system's functionality. 

| Subclass | Primary GUI Focus | Key Functionality |
| :--- | :--- | :--- |
| **AdminMain** | **System Management Dashboard** | **CRUD** (Create, Read, Update, Delete) controls for all user types, system configuration, and audit log access. |
| **StudentIntern** | **Personal Progress Tracker** | Forms for submitting **Time Logs** and **Tasks**, viewing **progress bars**, and checking `Evaluation` scores. |
| **School** | **Oversight and Verification** | Tools to review student placements, verify company legitimacy, and monitor overall internship program statistics. |
| **Company** | **Internship Management Suite** | Interfaces for creating new internships, assigning tasks, and inputting formal **Student `Evaluation`** scores. |

---

### 2.  Subclass-Specific Notification Panel

A dedicated notification system will be integrated into the GUI of each user type to provide **actionable alerts** and **critical status updates** in real-time. 

#### Notification Flows by Account:

| Subclass | Primary Notification Triggers | Purpose/Action Required |
| :--- | :--- | :--- |
| **AdminMain** | New School/Company Registration requests, System health alerts. | **Action:** Review and approve/deny new accounts. |
| **StudentIntern** | Time Log/Task Approval/Decline status, Upcoming report deadlines. | **Action:** Check status; Resubmit declined items; Complete required tasks. |
| **School** | Student Placement Verification requests, Received final `Evaluation` reports. | **Action:** Review student status; Archive official records. |
| **Company** | **Pending Time Log/Task Approvals** submitted by the intern, Internship end date reminders. | **Action:** Review and approve/decline submitted logs. |

---

### 3.  Robust Password Security (Hashing)

To replace simple encryption and enhance security, we will implement industry-standard **one-way hashing** with **salting**.

* **Goal:** The system will **never** store plain-text passwords.
* **Algorithm:** Utilize a modern, computationally slow hashing algorithm such as **Bcrypt** or **Argon2** (recommended).
* **Implementation:** Upon user registration, a **unique salt** will be generated and combined with the password before hashing. Both the final hash and the salt will be stored in the database. This protects credentials even if the database is compromised. 

---

### 4.  Proper Time Logging Implementation (Replacing Regex)

The current reliance on **regex** for time logging validation is insufficient and will be replaced by robust validation and calculation logic using **date/time objects**.

* **Data Type:** Store `StartDateTime` and `EndDateTime` using reliable database **TIMESTAMP** or **DATETIME** types.
* **Validation Logic:** Implement server-side business logic to ensure:
    * The `EndDateTime` is logically **after** `StartDateTime`.
    * The duration is within reasonable limits.
    * The new log **does not overlap** with any existing approved or pending log for that student.
* **Calculation:** Use programming language functions to reliably calculate the duration:
    $$\text{Duration} = \text{EndDateTime} - \text{StartDateTime}$$

