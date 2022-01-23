// var student = new Object(); //Object Constructor Syntax

// student.name = 'Sundar';

// console.log(student instanceof Object);

/*********************************/

// var employee = {} //Object Literal Syntax

// employee.name = 'Mark';

// employee.work = function(){
//     for (let i = 0; i < 10; i++)
//     {
//         console.log(i);
//     }
// };

// for (i in employee)
//     console.log(i, employee);

/*********************************/

//Data Property

// var student1 = {
//     name : 'Jon',
//     age : 16,
//     class : 12
// };

// Object.defineProperty(student1, 'name', {
//     configurable : false,
//     writable : false,
//     enumerable : false
// });

// delete student1.name;

// student1.name = 'Sam';

// console.log(student1);

// for (i in student1)
//     console.log(i, student1[i]);

/*********************************/

//accessor property

// var employee = {
//     name : 'Jon',
//     salary : 10000,
//     experience : 7,
//     bonus : 0
// };

// Object.defineProperty(employee, 'bonuses', {
//     get : function() {
//         return this.bonus;
//     },
//     set : function(newBonus) {
//         if (this.experience > 5)
//             this.bonus = newBonus;
//     }
// });
// console.log(employee);
// employee.bonuses = 5000;
// console.log(employee);



/*********************************/

// data properties

// var employee = {};

// Object.defineProperties(employee, {
//     name : {
//         enumerable : true,
//         writable : false,
//         value : 'Jon'
//     },
//     salary : {
//         enumerable : true,
//         writable : true,
//         value : 10000
//     },
//     experience : {
//         enumerable : true,
//         writable : true,
//         value : 5
//     },
//     bonus : {
//         enumerable : true,
//         writable : true,
//         value : 0
//     },
//     bonuses : {
//         get : function() {
//             return this.bonus;
//         },
//         set : function(newBonus) {
//             if(this.experience > 5)
//                 this.bonus = newBonus;
//         }
//     }
// });

// employee.experience = 6;
// employee.bonuses = 5000;

// for (i in employee)
//     console.log(i, employee[i]);


//Constructor function

// class Employee
// {
//     constructor(name, experience, salary)
//     {
//         this.name = name;
//         this.experience = experience;
//         this.salary = salary;
//     }
// }

// function Student(){
//     this.name = 'Jon',
//     this.mark = 75
// }

// console.log(new Student());

// var employee1 = new Employee('Jon', 7, 10000);
// var employee2 = new Employee('Perry', 5, 10000);

// console.log(employee1);
// console.log(employee2);

// employee1.name = 'Don';

// console.log(employee1);


