import { createRouter, createWebHistory } from 'vue-router/dist/vue-router.esm-bundler'
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
        path: '/add',
        component: AddTeacher
    }
]
export default () => createRouter({
    history:createWebHistory(),
    routes: routes
})