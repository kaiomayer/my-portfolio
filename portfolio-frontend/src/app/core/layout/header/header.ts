import { Component } from '@angular/core';
import {NavItem} from '../../../shared/models/navItem.model';
import {RouterLink, RouterLinkActive} from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './header.html',
  styleUrl: './header.scss'
})
export class Header {

  public navItems: NavItem[] = [
    {
      "text": "Sobre mim",
      "url": "/about"
    },
    {
      "text": "Projetos",
      "url": "/projects"
    },
    {
      "text": "Experiência",
      "url": "/experience"
    },
    {
      "text": "Contato",
      "url": "/contact"
    }, 
    {
      "text": "Login",
      "url": "/login"
    }, 
    {
      "text": "Editar",
      "url": "/edit"
    }, 
    {
      "text": "Logout",
      "url": "/logout"
    }
  ];
}
