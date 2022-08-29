import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
const URL = "http://localhost:8083/user1"
@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  save(user: any) {
    return this.http.post(URL,user);
  }
  constructor(public http :HttpClient) { }

}
