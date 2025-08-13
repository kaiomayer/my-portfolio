import { Component } from '@angular/core';
import {NgOptimizedImage} from '@angular/common';
import {NavItem} from '../../../shared/models/navItem.model';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-header',
  imports: [
    NgOptimizedImage,
    RouterLink
  ],
  templateUrl: './header.html',
  styleUrl: './header.scss'
})
export class Header {

  public navItems: NavItem[] = [
    {
      "text": "Sobre mim",
      "url": "/about-me"
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
    }
  ];


}
