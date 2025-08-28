import { Component } from '@angular/core';
import 'animate.css';
import { ButtonComponent } from '../../core/layout/button/button.component';
import { Router } from '@angular/router';
import {MatButton} from '@angular/material/button';


@Component({
  selector: 'app-about-me',
  imports: [ButtonComponent],
  templateUrl: './about-me.html',
  styleUrl: './about-me.scss'
})

export class AboutMe {

  lang: 'pt' | 'en' = 'pt';

  texts = {
    pt: {
      title: 'Olá, eu sou',
      name: 'Nome',
      subtitle: 'Sou um desenvolvedor Front-end com 10 anos de experiência',
      presentation: 'Olá! Sou um desenvolvedor full-stack apaixonado, com mais de 5 anos de experiência na criação de soluções digitais que geram impacto real. Atualmente estou no 4º período da faculdade de Engenharia de Software buscando sempre me desenvolver ainda mais.',
      buttonWork: 'Conheça mais sobre meu trabalho',
      buttonCV: 'Baixar CV',
      sectionTitle: 'Sobre mim'
    },
    en: {
      title: 'Hi, I am',
      name: 'Name',
      subtitle: 'I am a Front-end developer with 10 years of experience',
      presentation: 'Hi! I am a passionate full-stack developer with more than 5 years of experience creating digital solutions that make a real impact. I am currently in the 4th semester of Software Engineering, constantly striving to improve my skills.',
      buttonWork: 'Check out my work',
      buttonCV: 'Download CV',
      sectionTitle: 'About Me'
    }
  };

  constructor(private router: Router) {}

  handleButtonClick() {
    this.router.navigate(['/projects']);
  }

  // Troca de idioma
  changeLanguage(lang: 'pt' | 'en') {
    this.lang = lang;
  }
}
