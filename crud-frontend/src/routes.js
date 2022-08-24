import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

const router = new Router({
    mode: 'history',
    routes: [
        {
            path: "/",
            name: "HomePage",
            component: () => import("./components/DashBoard"),
        },
        {
            path: "/category",
            name: "Categories",
            component: () => import("./components/CategoryPage"),
        },
        {
            path: "/category/:id",
            name: "Category",
            component: () => import("./components/Category"),
        },
        {
            path: "/site",
            name: "SitePage",
            component: () => import("./components/SitePage")
        },
        {
            path: "/site/:id",
            name: "Site",
            component: () => import("./components/Site")
        },
        {
            path:"/site-new",
            name:'SiteSave',
            component: () => import("./components/Site")
        }
    ]
});

export default router;