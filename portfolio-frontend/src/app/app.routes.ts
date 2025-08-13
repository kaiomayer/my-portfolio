import { Routes } from '@angular/router';
import {Projects} from './domain/projects/projects';
import {Experience} from './domain/experience/experience';
import {AboutMe} from './domain/about-me/about-me';
import {Contact} from './domain/contact/contact';


export const routes: Routes = [
  {
    path: '',
    redirectTo: '/about-me',
    pathMatch: 'full',
  },
  {
    path: 'about-me',
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
  }
];
