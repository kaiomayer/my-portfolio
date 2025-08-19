import { Routes } from '@angular/router';
import {Projects} from './domain/projects/projects';
import {Experience} from './domain/experience/experience';
import {AboutMe} from './domain/about-me/about-me';
import {Contact} from './domain/contact/contact';
import { Login } from './domain/login/login';
import { Edit } from './domain/edit/edit';
import { NotFound } from './domain/not-found/not-found';


export const routes: Routes = [
  {
    path: '',
    redirectTo: '/about',
    pathMatch: 'full',
  },
  {
    path: 'about',
    component: AboutMe
  },
  {
    path: 'projects',
    component: Projects
  },
  {
    path: 'experience',
    component: Experience
  },
  {
    path: 'contact',
    component: Contact
  },
  {
    path: 'login',
    component: Login
  },
  {
    path: 'edit',
    component: Edit
  },
  {
    path: '**',
    component: NotFound
  }
];
