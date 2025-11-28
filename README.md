# PRAXIS-FLOW-Assign.-Track.-Evaluate.

**Description**
The Praxis Flow system is a comprehensive internship and partnership management platform designed to connect students/interns, companies, schools, and administrators. Its primary function is to facilitate the entire internship lifecycle, from registration and task management to progress monitoring, evaluation, and establishing official partnerships.

## ⚙️ OOP Concepts Applied

We applied the following OOP principles to ensure a robust and scalable architecture:

### **Inheritance** (Code Reusability)
Allows sub-classes to reuse methods from parent classes.
* **Classes Used:** `Student Intern`, `Company`, `School`, `AdminMain`

### **Encapsulation** (Data Protection)
Bundles data and the methods that operate on it, limiting direct access to maintain integrity.
* **Classes Used:** `Evaluation`, `Internship`, `Task`, `TimeLog`

### **Polymorphism** (Flexible Behavior)
Allows objects to implement a common method differently, depending on their type.
* **Classes Used:** `Student Intern`, `Company`, `School`, `AdminMain`

### **Abstract Class and Interface** (Defining Contracts)
Ensures specific classes adhere to a mandatory set of methods.
* **Classes Used:** `User`, `Student Intern`, `Company`, `Evaluate`, `Tracker`


---

## ✍️ Authors

* John Daniel Labiano
* John Greig Galarbe
* Joyce Cornel

## 🙏 Acknowledgements

We are grateful to our professor, Sir Emmanuel Charlie Enriquez, for their guidance and support.

## 🚀 Future Enhancements

We have identified the following key areas for future development to significantly improve the system's security, usability, and functionality.

---

### 1. 🖼️ Comprehensive Graphical User Interface (GUI)

The current interface will be replaced with dedicated GUIs for each user subclass to provide a clearer, more efficient, and role-specific view of the system's functionality. 

| Subclass | Primary GUI Focus | Key Functionality |
| :--- | :--- | :--- |
| **AdminMain** | **System Management Dashboard** | **CRUD** (Create, Read, Update, Delete) controls for all user types, system configuration, and audit log access. |
| **StudentIntern** | **Personal Progress Tracker** | Forms for submitting **Time Logs** and **Tasks**, viewing **progress bars**, and checking `Evaluation` scores. |
| **School** | **Oversight and Verification** | Tools to review student placements, verify company legitimacy, and monitor overall internship program statistics. |
| **Company** | **Internship Management Suite** | Interfaces for creating new internships, assigning tasks, and inputting formal **Student `Evaluation`** scores. |

---

### 2. 🔔 Subclass-Specific Notification Panel

A dedicated notification system will be integrated into the GUI of each user type to provide **actionable alerts** and **critical status updates** in real-time. 

#### Notification Flows by Account:

| Subclass | Primary Notification Triggers | Purpose/Action Required |
| :--- | :--- | :--- |
| **AdminMain** | New School/Company Registration requests, System health alerts. | **Action:** Review and approve/deny new accounts. |
| **StudentIntern** | Time Log/Task Approval/Decline status, Upcoming report deadlines. | **Action:** Check status; Resubmit declined items; Complete required tasks. |
| **School** | Student Placement Verification requests, Received final `Evaluation` reports. | **Action:** Review student status; Archive official records. |
| **Company** | **Pending Time Log/Task Approvals** submitted by the intern, Internship end date reminders. | **Action:** Review and approve/decline submitted logs. |

---

### 3. 🔐 Robust Password Security (Hashing)

To replace simple encryption and enhance security, we will implement industry-standard **one-way hashing** with **salting**.

* **Goal:** The system will **never** store plain-text passwords.
* **Algorithm:** Utilize a modern, computationally slow hashing algorithm such as **Bcrypt** or **Argon2** (recommended).
* **Implementation:** Upon user registration, a **unique salt** will be generated and combined with the password before hashing. Both the final hash and the salt will be stored in the database. This protects credentials even if the database is compromised. 

---

### 4. ⏳ Proper Time Logging Implementation (Replacing Regex)

The current reliance on **regex** for time logging validation is insufficient and will be replaced by robust validation and calculation logic using **date/time objects**.

* **Data Type:** Store `StartDateTime` and `EndDateTime` using reliable database **TIMESTAMP** or **DATETIME** types.
* **Validation Logic:** Implement server-side business logic to ensure:
    * The `EndDateTime` is logically **after** `StartDateTime`.
    * The duration is within reasonable limits.
    * The new log **does not overlap** with any existing approved or pending log for that student.
* **Calculation:** Use programming language functions to reliably calculate the duration:
    $$\text{Duration} = \text{EndDateTime} - \text{StartDateTime}$$








