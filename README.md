Students Web Application

This web application allows you to view, add and manage student records. Each student is represented by a rectangle on the main page, and the attributes of the student are visually represented within the rectangle. Here's how the student information relates to the rectangle:

Rectangle Size: The width and height of the rectangle are determined by the weight and height of the student, respectively. The formula used to calculate the dimensions is width: weight * 2.5px; height: heightpx;.

Border Color: The border color of the rectangle corresponds to the hair color of the student. The hair color is dynamically applied to the border using the border-color property.

Border Width: The border width of the rectangle is determined by the age of the student. The formula used to calculate the border width is border-width: age * 0.19px;.

Text Content: Inside the rectangle, the student's name is displayed as a heading (h4) with the text dynamically populated from the student record. The color of the name text matches the hair color of the student.

GPA Font Size: The font size of the GPA displayed inside the rectangle is determined by the student's GPA value. The formula used to calculate the font size is font-size: GPA * 5px;.

In addition to the visual representation, each rectangle also includes an "Edit" button that allows you to modify the student's attributes. Clicking on the "Edit" button redirects you to the form where you can update the student information.