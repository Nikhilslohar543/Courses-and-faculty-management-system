import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class RoleGuard implements CanActivate {
  constructor(private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const expectedRole = route.data['role']; // Fetch the expected role from route data
    const userRole = sessionStorage.getItem('fRole'); // Get the current user's role from session storage

    if (userRole === expectedRole) {
      return true; // Allow access if the role matches
    }
    else{
      // Redirect to signin if the role doesn't match
    this.router.navigate(['/home/signin']);
    return false;
    }
  }
}