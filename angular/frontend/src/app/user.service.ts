import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
const URL = "http://localhost:8083/user"
@Injectable({
  providedIn: 'root'
})
export class UserService {
  // "/user/id/{id}
  save(user: any) {
        return this.http.post(URL,user);
  }
  getAllUser() {
    return this.http.get(URL);
}
deleteUser(id:number) {
  return this.http.delete(URL+'/'+ id);
}
  constructor(public http :HttpClient) { }

}
