import { Component } from '@angular/core';
import 'animate.css';
import { ButtonComponent } from '../../core/layout/button/button.component';
import { Router } from '@angular/router';


@Component({
  selector: 'app-about-me',
  imports: [ButtonComponent],
  templateUrl: './about-me.html',
  styleUrl: './about-me.scss'
})
export class AboutMe {
  constructor(private router: Router) {}

  handleButtonClick(): void {
    this.router.navigate(['/projects']);  
  }
}
