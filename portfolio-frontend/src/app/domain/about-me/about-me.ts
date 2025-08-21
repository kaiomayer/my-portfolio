import { Component } from '@angular/core';
import 'animate.css';
import { ButtonComponent } from '../../core/layout/button/button.component';
import { Router } from '@angular/router';
import {MatButton} from '@angular/material/button';


@Component({
  selector: 'app-about-me',
  imports: [ButtonComponent, MatButton],
  templateUrl: './about-me.html',
  styleUrl: './about-me.scss'
})
export class AboutMe {
  constructor(private router: Router) {}

  handleButtonClick(): void {
    this.router.navigate(['/projects']);
  }
}
