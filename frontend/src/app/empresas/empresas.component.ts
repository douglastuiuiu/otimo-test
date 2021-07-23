import {Component, OnInit} from '@angular/core';
import {EmpresasService} from "../empresas.service";

@Component({
  selector: 'app-empresas',
  templateUrl: './empresas.component.html',
  styleUrls: ['./empresas.component.scss']
})
export class EmpresasComponent implements OnInit {

  empresas: Array<any> = new Array<any>();

  constructor(private empresasService: EmpresasService) {
  }

  ngOnInit(): void {
    this.listarEmpresas()
  }

  listarEmpresas() {
    this.empresasService.listarEmpresas().subscribe(empresas => {
      this.empresas = empresas["content"]
    }, error => {
      console.log('Erro ao listar as empresas', error);
    })
  }

}
