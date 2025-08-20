import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Router } from '@angular/router';
import { ButtonComponent } from "../../../../core/layout/button/button.component";

@Component({
  selector: 'app-unauthorized',
  imports: [RouterModule, ButtonComponent],
  templateUrl: './unauthorized.component.html',
  styleUrl: './unauthorized.component.scss'
})
export class Unauthorized {
  constructor(private router: Router) {}

  handlebuttonclick(): void {
    this.router.navigate(['/about'])
  }
}
