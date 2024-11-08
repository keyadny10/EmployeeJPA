import { createRouter,createMemoryHistory } from "vue-router";
import Home from "../login/Home.vue"
import About from "../view/About.vue"
import Delete from "../view/Delete.vue"
import Query from "../view/Query.vue"
import Updata from "../view/Updata.vue"
import Add from "../view/Add.vue"
import Login from "../view/Loging.vue"
import AddManager from "../login/AddManager.vue"




var routes=[
    {path:"/",component:Home},
    {path:"/login",component:Login},
    {path:"/addManager",component:AddManager,meta: { requiresAuth: true }},
    {path:"/about",component:About},
    {path:"/query",component:Query, meta: { requiresAuth: true }},
    {path:"/delete",component:Delete, meta: { requiresAuth: true }},
    {path:"/updata",component:Updata, meta: { requiresAuth: true }},
    {path:"/add",component:Add, meta: { requiresAuth: true }},
];

var router=createRouter({
    history:createMemoryHistory(),routes
});
router.beforeEach((to, from, next) => {
    const isLoggedIn = localStorage.getItem('isLoggedIn');
    if (to.meta.requiresAuth && !isLoggedIn) {
        next({ path: '/login' });
    } else {
        next();
    }
});
export default router;