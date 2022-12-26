import {createRouter, createWebHistory} from 'vue-router/dist/vue-router.esm-bundler'
import Home from '@/pages/HomePage.vue'
import Schedule from '@/pages/SchedulePage'
import Faculty from "@/pages/FacultyPage";
import Department from "@/pages/DepartmentPage";
import Group from "@/pages/GroupPage";
import Disciplines from "@/pages/DisciplinesPage";
import Teachers from "@/pages/TeachersPage";
import Students from "@/pages/StudentsPage";
import NewsPage from "@/pages/NewsPage";
import AddTeacher from "@/components/TeacherComponents/AddTeacher";
import UpdateTeacher from "@/components/TeacherComponents/UpdateTeacher";
import AddFaculty from "@/components/FacultyComponents/AddFaculty";
import UpdateFaculty from "@/components/FacultyComponents/UpdateFaculty";
import AddDiscipline from "@/components/DisciplinesComponents/AddDiscipline";
import UpdateDiscipline from "@/components/DisciplinesComponents/UpdateDiscipline";
import AddStudent from "@/components/StudentComponents/AddStudent";
import UpdateStudent from "@/components/StudentComponents/UpdateStudent";
import AddGroup from "@/components/GroupComponents/AddGroup";
import UpdateGroup from "@/components/GroupComponents/UpdateGroup";
import AddDepartment from "@/components/DepartmentComponents/AddDepartment";
import UpdateDepartment from "@/components/DepartmentComponents/UpdateDepartment";


const routes = [
    {
        path: '/',
        component: Home
    },
    {
        path: '/schedule',
        component: Schedule
    },
    {
        path: '/news',
        component: NewsPage
    },
    {
        path: '/faculty',
        component: Faculty
    },
    {
        path: '/department',
        component: Department
    },
    {
        path: '/group',
        component: Group
    },
    {
        path: '/disciplines',
        component: Disciplines
    },
    {
        path: '/teachers',
        component: Teachers
    },
    {
        path: '/students',
        component: Students
    },
    {
        path: '/addTeacher',
        component: AddTeacher
    },
    {
        path: '/updateTeacher/:id',
        component: UpdateTeacher
    },
    {
        path: '/addFaculty',
        component: AddFaculty
    },
    {
        path: '/updateFaculty/:id',
        component: UpdateFaculty
    },
    {
        path: '/addDiscipline',
        component: AddDiscipline
    },
    {
        path: '/updateDiscipline/:id',
        component: UpdateDiscipline
    },
    {
        path: '/addStudent',
        component: AddStudent
    },
    {
        path: '/updateStudent/:id',
        component: UpdateStudent
    },
    {
        path: '/addGroup',
        component: AddGroup
    },
    {
        path: '/updateGroup/:id',
        component: UpdateGroup
    },
    {
        path: '/addDepartment',
        component: AddDepartment
    },
    {
        path: '/updateDepartment/:id',
        component: UpdateDepartment
    }
]
export default () => createRouter({
    history: createWebHistory(),
    routes: routes
})