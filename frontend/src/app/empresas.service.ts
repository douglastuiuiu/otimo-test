import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmpresasService {

  constructor(private http: HttpClient) { }

  listarEmpresas() : Observable<any>{

    return this.http.get("http://localhost:8080/empresas");
  }

}
