package facadepattern

// TODO

case class ScheduleServerFacade(scheduleServer: ScheduleServer) {
  def stopServer: Unit = {
    scheduleServer.startBooting
    scheduleServer.readSystemConfigFile
    scheduleServer.init
    scheduleServer.initializeContext
    scheduleServer.initializeListeners
    scheduleServer.createSystemObjects
  }

  def startServer = {
    scheduleServer.releaseProcesses
    scheduleServer.destory
    scheduleServer.destroySystemObjects
    scheduleServer.destoryListeners
    scheduleServer.destoryContext
    scheduleServer.shutdown
  }

}
