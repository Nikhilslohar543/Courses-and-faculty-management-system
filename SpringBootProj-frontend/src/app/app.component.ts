import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  isLoggedIn(): boolean {
    return !!sessionStorage.getItem('fId');
  }

  title = 'SpringBootProj-frontend';
}
